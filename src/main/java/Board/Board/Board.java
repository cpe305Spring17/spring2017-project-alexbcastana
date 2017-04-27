package Board.Board;

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

    for(int count = 0; count < SIZE; count++) {

      for (int counter = 0; counter < SIZE; counter++) {
        isBlack = false;
        isOccupied = false;

        if(count < RED_SIDE && counter % 2 != 0) {
          isOccupied = true;
        }
        else if(count > BLACK_SIDE && counter % 2 == 0) {
          isBlack = isOccupied = true;
        }
        checkerBoard[count][counter] = new Square(isOccupied,  isBlack, false);
      }
    }
  }

  public void drawBoard() {

    for(int count = 0; count < SIZE; count++) {

      for(int counter = 0; counter < SIZE; counter++) {

        System.out.print(checkerBoard[count][counter].toString());
      }
      System.out.println("");
    }
  }
}

