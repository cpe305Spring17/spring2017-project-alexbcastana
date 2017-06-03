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

    System.out.println("  A    B    C    D    E    F    G    H ");
    for (int count = 0; count < SIZE; count++) {

      printUpperBound();

      for (int counter = 0; counter < SIZE; counter++) {

        System.out.print(checkerBoard[count][counter].toString());
      }
      System.out.println(" " + count);
    }
  }

  public Square getSquare(int locationX, int locationY) {

    return checkerBoard[locationX][locationY];

  }


  public int getRLost() {
    return rLost;
  }

  public int getYLost() {
    return yLost;
  }

  private void printUpperBound() {

    int counter = 0;
    while (counter++ < 8) {
      System.out.print("+---+");
    }
    System.out.println();

  }

  public void setSquare(int toChangeX, int toChangeY, Square change) {

    checkerBoard[toChangeX][toChangeY] = change;

  }

  public void setRLost(int number) {
    rLost = number;
  }

  public void setYLost(int number) {
    yLost = number;
  }
}

