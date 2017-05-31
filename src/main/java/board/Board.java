package board;

import board.pieces.Pawn;

/**
 * Created by Marthxander on 4/25/2017.
 */

public class Board {

  private final int SIZE = 8;
  private final int RED_SIDE = 3;
  private final int YELLOW_SIDE = 4;
  private int yLost;
  private int rLost;

  private Square[][] checkerBoard;

  public Board() {

    checkerBoard = new Square[SIZE][SIZE];
    boolean isOccupied;
    boolean isYellow;

    for (int count = 0; count < SIZE; count++) {

      for (int counter = 0; counter < SIZE; counter++) {
        isYellow = false;
        isOccupied = false;

        if (count < RED_SIDE && counter % 2 != 0) {
          isOccupied = true;
        } else if (count > YELLOW_SIDE && counter % 2 == 0) {
          isYellow = isOccupied = true;
        }
        checkerBoard[count][counter] = new Square(isOccupied,  isYellow, false);
      }
    }
    yLost = 0;
    rLost = 0;
  }

  public void drawBoard() {

    System.out.println(" A  B  C  D  E  F  G  H ");
    for (int count = 0; count < SIZE; count++) {

      for (int counter = 0; counter < SIZE; counter++) {

        System.out.print(checkerBoard[count][counter].toString());
      }
      System.out.println(" " + count);
    }
  }

  public Square getSquare(int locationX, int locationY) {

    return checkerBoard[locationX][locationY];

  }

  public boolean makeMove(int originX, int originY, int nextX, int nextY) {

    int captureLocX, captureLocY, xCoor, yCoor;
    boolean flag;
    Square origin;
    origin = checkerBoard[originX][originY];

    rLost = 0;
    yLost = 0;

    xCoor = nextX - originX;
    yCoor = nextY - originY;
    captureLocX = determineCaptureSign(originX, xCoor);
    captureLocY = determineCaptureSign(originY, yCoor);

    if (origin.getPiece() instanceof Pawn) {
      flag = checkPawnMove(originX, originY, xCoor, yCoor, captureLocX, captureLocY);
    }
    else {
      flag = checkKingMove(originX, originY, xCoor, yCoor, captureLocX, captureLocY);
    }
    if (flag) {
      checkerBoard[nextX][nextY] = checkerBoard[originX][originY];
      checkerBoard[originX][originY] = new Square(false, false, false);
      checkerBoard[nextX][nextY].kingMe(nextX);
      //change turn
    }
    return flag;
  }

  private boolean checkPawnMove(int originX, int originY, int xCoor, int yCoor, int captureLocX, int captureLocY) {

    if ((xCoor == -1 || xCoor == 1) && (yCoor == -1 || yCoor == 1)) {
      return true;
    }
    else if ((xCoor == 2 || xCoor == -2) && (yCoor == 2 || yCoor == -2)) {
      return checkForCapture(checkerBoard[originX][originY], captureLocX, captureLocY);
    }
    return false;
  }

  private boolean checkKingMove(int originX, int originY, int xCoor, int yCoor, int captureLocX, int captureLocY) {

    if ((xCoor >= -1 && xCoor <= 1) && (yCoor >= -1 && xCoor <= 1)) {
      return true;
    }
    else if ((xCoor == 2 || xCoor == -2) && (yCoor <= 2 && yCoor >= -2)) {
      return checkForCapture(checkerBoard[originX][originY], captureLocX, captureLocY);
    }
    else if ((xCoor <= 2 && xCoor >= -2) && (yCoor == 2 || yCoor == -2)) {
      return checkForCapture(checkerBoard[originX][originY], captureLocX, captureLocY);
    }
    return false;
  }

  private boolean checkForCapture(Square origin, int tempX, int tempY) {

    String temp;
    boolean flag = false;


    try {
      temp = checkerBoard[tempX][tempY].getPiece().getFaction();
      if (!origin.getPiece().getFaction().equals(temp) && !"Empty".equals(temp)) {
        flag = true;
      }
    }
    catch (Exception except){
      flag = false;
    }

    if (flag) {
      takePiece(tempX, tempY);
    }
    return flag;
  }

  private void takePiece(int tempX, int tempY) {
    if (checkerBoard[tempX][tempY].getPiece().getFaction().equals("Red")) {
      rLost = 1;
    }
    else {
      yLost = 1;
    }
    checkerBoard[tempX][tempY] = new Square(false, false, false);
  }

  public int getRLost() {
    return rLost;
  }

  public int getYLost() {
    return yLost;
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
}

