package board;

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

    System.out.println(checkerBoard[originX][originY].toString());
    checkerBoard[nextX][nextY] = checkerBoard[originX][originY];
    checkerBoard[originX][originY] = new Square(false, false, false);

  }


}

