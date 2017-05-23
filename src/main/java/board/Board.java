package board;

import board.pieces.Pawn;

/**
 * Created by Marthxander on 4/25/2017.
 */

public class Board {

  private final int SIZE = 8;
  private final int RED_SIDE = 3;
  private final int BLACK_SIDE = 4;

  private Square[][] checkerBoard;

  public Board() {

    checkerBoard = new Square[SIZE][SIZE];
    boolean isOccupied;
    boolean isBlack;

    for (int count = 0; count < SIZE; count++) {

      for (int counter = 0; counter < SIZE; counter++) {
        isBlack = false;
        isOccupied = false;

        if (count < RED_SIDE && counter % 2 != 0) {
          isOccupied = true;
        } else if (count > BLACK_SIDE && counter % 2 == 0) {
          isBlack = isOccupied = true;
        }
        checkerBoard[count][counter] = new Square(isOccupied,  isBlack, false);
      }
    }
  }

  public void drawBoard() {

    System.out.println(" 0  1  2  3  4  5  6  7 ");
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

  public void makeMove(int originX, int originY, int nextX, int nextY) {

    int captureLocX, captureLocY, xCoor, yCoor;
    boolean flag;
    Square origin, next;
    origin = checkerBoard[originX][originY];

    xCoor = nextX - originX;
    yCoor = nextY - originY;
    captureLocX = originX + xCoor;
    captureLocY = originY + yCoor;

    if (origin.getPiece() instanceof Pawn) {
      System.out.println("Pawn Check" + xCoor + " " + yCoor);
      flag = checkPawn(originX, originY, xCoor, yCoor, captureLocX, captureLocY);
    }
    else {
      flag = checkKing(originX, originY, xCoor, yCoor, captureLocX, captureLocY);
    }
    System.out.println(flag);
    if (flag) {
      checkerBoard[nextX][nextY] = checkerBoard[originX][originY];
      checkerBoard[originX][originY] = new Square(false, false, false);
    }
  }

  private boolean checkPawn(int originX, int originY, int xCoor, int yCoor, int captureLocX, int captureLocY) {

    if ((xCoor == -1 || xCoor == 1) && (yCoor == -1 || yCoor == 1)) {
      return true;
    }
    else if ((xCoor == 2 || xCoor == -2) && (yCoor == 2 || yCoor == -2)) {
      return checkForCapture(checkerBoard[originX][originY], captureLocX, captureLocY);
    }
    return false;
  }

  private boolean checkKing(int originX, int originY, int xCoor, int yCoor, int captureLocX, int captureLocY) {

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

    boolean flag = false;

    try {
      if (!origin.getPiece().getFaction().equals(checkerBoard[tempX][tempY].getPiece().getFaction())) {
        flag = true;
      }
    }
    catch (Exception except){
      flag = false;
    }

    return flag;
  }

}

