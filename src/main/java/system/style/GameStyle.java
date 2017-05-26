package system.style; /**
 * Created by Marthxander on 4/27/2017.
 */
import board.Board;
import board.Square;

public abstract class GameStyle {

  private final int STARTING_PIECES = 12;
  private int timeRemaining;
  private int rPieces;
  private int bPieces;
  private Board board;
  private int turnCount;

  public GameStyle() {
    timeRemaining = 0;
    turnCount = 0;
    rPieces = STARTING_PIECES;
    bPieces = STARTING_PIECES;
  }
  public void startGame(Board board) {
    this.board = board;
    board.drawBoard();
    getPieceChanges();
    System.out.println(determineTurn());
  }

  public int getTimeRemaining() {
    return timeRemaining;
  }

  public int getTurnCount() {
    return turnCount;
  }

  public int getBPieces() {
    return bPieces;
  }

  public int getRPieces() {
    return rPieces;
  }

  public void incTurnCount() {
    turnCount++;
  }

  public void decBPieces() {
    bPieces--;
  }

  public void decRPieces() {
    rPieces--;
  }

  public void move(int originX, int originY, int nextX, int nextY) {

    boolean flag = false;

    if (moveIsValid(originX, originY, nextX, nextY)) {
      flag = board.makeMove(originX, originY, nextX, nextY);
    }
    board.drawBoard();
    getPieceChanges();
    if (!flag) {
      System.out.println("That move is not valid");
    }
    else {
      incTurnCount();
    }
    System.out.println(determineTurn());
  }

  private boolean moveIsValid(int originX, int originY, int nextX, int nextY) {


    Square start, end;

    start = board.getSquare(originX, originY);
    end = board.getSquare(nextX, nextY);
    return correctTurn(start) && start.isOccupied() && !end.isOccupied();
  }

  private boolean correctTurn(Square start) {
    if (turnCount % 2 == 0) {
      //red turn
      return start.getPiece().getFaction().equals("Red");
    }
    return start.getPiece().getFaction().equals("Black");
  }

  private String determineTurn() {

    if (turnCount % 2 == 0) {
      return "It is Red's Turn";
    }
    return "It is Black's Turn";
  }

  public void getPieceChanges() {
    if (board.getRLost() == 1) {
      rPieces--;
    }
    if (board.getBLost() == 1) {
      bPieces--;
    }
    System.out.println("Remaining Red Pieces: " + rPieces);
    System.out.println("Remaining Black Pieces: " + bPieces);
  }
}

