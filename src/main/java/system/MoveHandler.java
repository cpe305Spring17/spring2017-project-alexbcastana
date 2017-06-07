package system;

import board.Square;
import board.pieces.Pawn;
import board.Board;

/**
 * Created by Marth on 6/3/2017.
 */
public class MoveHandler {

    private Board board;

    public MoveHandler(Board board) {
        this.board = board;
    }

    public boolean makeMove(int originX, int originY, int nextX, int nextY) {

        int captureLocX, captureLocY, xCoor, yCoor;
        boolean flag, kingAdded;
        Square origin;
        kingAdded = false;
        origin = board.getSquare(originX, originY);

        xCoor = nextX - originX;
        yCoor = nextY - originY;
        captureLocX = determineCaptureSign(originX, xCoor);
        captureLocY = determineCaptureSign(originY, yCoor);

        board.setRLost(0);
        board.setYLost(0);
        board.setRKings(0);
        board.setYKings(0);
        if (origin.getPiece() instanceof Pawn) {
            flag = checkPawnMove(originX, originY, xCoor, yCoor, captureLocX, captureLocY);
        }
        else {
            flag = checkKingMove(originX, originY, xCoor, yCoor, captureLocX, captureLocY);
        }
        if (flag) {
            board.setSquare(nextX, nextY, board.getSquare(originX, originY));
            board.setSquare(originX, originY, new Square(false, false, false));
            kingAdded = board.getSquare(nextX, nextY).kingMe(nextX);
            //change turn
        }
        if (kingAdded) {
            board.incKing(nextX, nextY);
        }
        return flag;
    }

    private boolean checkPawnMove(int originX, int originY, int xCoor, int yCoor, int captureLocX, int captureLocY) {

        if ((xCoor == -1 || xCoor == 1) && (yCoor == -1 || yCoor == 1)) {
            return true;
        }
        else if ((xCoor == 2 || xCoor == -2) && (yCoor == 2 || yCoor == -2)) {
            return checkForCapture(board.getSquare(originX, originY), captureLocX, captureLocY, true);
        }
        return false;
    }

    private boolean checkKingMove(int originX, int originY, int xCoor, int yCoor, int captureLocX, int captureLocY) {

        if ((xCoor >= -1 && xCoor <= 1) && (yCoor >= -1 && xCoor <= 1)) {
            return true;
        }
        else if ((xCoor == 2 || xCoor == -2) && (yCoor <= 2 && yCoor >= -2)) {
            return checkForCapture(board.getSquare(originX, originY), captureLocX, captureLocY, true);
        }
        else if ((xCoor <= 2 && xCoor >= -2) && (yCoor == 2 || yCoor == -2)) {
            return checkForCapture(board.getSquare(originX, originY), captureLocX, captureLocY, true);
        }
        return false;
    }

    private boolean checkForCapture(Square origin, int tempX, int tempY, boolean isMove) {

        String temp;
        boolean flag = false;


        try {
            temp = board.getSquare(tempX, tempY).getPiece().getFaction();
            if (!origin.getPiece().getFaction().equals(temp) && !"Empty".equals(temp)) {
                flag = true;
            }
        }
        catch (Exception except){
            flag = false;
        }

        if (flag && isMove) {
            takePiece(tempX, tempY, 1);
        }
        return flag;
    }

    private void takePiece(int tempX, int tempY, int piecesLost) {

        Square tempSquare = board.getSquare(tempX, tempY);

        if (tempSquare.getPiece().getFaction().equals("Red")) {
            board.setRLost(piecesLost);
            board.checkKingLost(tempX, tempY, false);
        }
        else {
            board.setYLost(piecesLost);
            board.checkKingLost(tempX, tempY, true);
        }
        board.setSquare(tempX, tempY, new Square(false, false, false));
    }

    private int determineCaptureSign(int value, int indicator) {
        if (indicator > 0) {
            return value + 1;
        }
        else if (indicator == 0) {
            return value;
        }
        return value - 1;
    }

    public boolean comboCheck(int originX, int originY, int changeX, int changeY) {

        int xLoc = determineCaptureSign(originX, changeX);
        int yLoc = determineCaptureSign(originY, changeY);

        if ((changeX == 2 || changeX == -2) && (changeY == 2 || changeY == -2)) {
            return checkForCapture(board.getSquare(originX, originY), xLoc, yLoc, false);
        }

         return false;
    }

    public boolean makeCombo(int[] coordinates, int size) {

        int locX, locY;
        int count = 0;
        int originX = coordinates[count++];
        int originY = coordinates[count++];
        int tempX, tempY;
        boolean kingAdded;

        board.setRLost(0);
        board.setYLost(0);

        while (count < size) {

            tempX = coordinates[count++];
            tempY = coordinates[count++];
            locY = determineCaptureSign(tempX, originX - tempX);
            locX = determineCaptureSign(tempY, originY - tempY);
            takePiece(locX, locY, size / 2 - 1);
        }

        board.setSquare(coordinates[count-1], coordinates[count-2], board.getSquare(originY, originX));
        board.setSquare(originY, originX, new Square(false, false, false));
        kingAdded = board.getSquare(coordinates[count-1], coordinates[count-2]).kingMe(coordinates[count-1]);
        return kingAdded;
    }
}
