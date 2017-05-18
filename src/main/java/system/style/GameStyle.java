package system.style; /**
 * Created by Marthxander on 4/27/2017.
 */
import board.Board;
import board.Square;

public abstract class GameStyle {

  private final int STARTING_PIECES = 12;
  private int timeRemaining;
  private int turnCount;
  private int rPieces;
  private int bPieces;
  private Board board;

  public GameStyle() {
    timeRemaining = 0;
    turnCount = 0;
    rPieces = STARTING_PIECES;
    bPieces = STARTING_PIECES;
  }
  public void startGame(Board board) {
    this.board = board;
    board.drawBoard();
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
    bPieces++;
  }

  public void decRPieces() {
    rPieces++;
  }

  public void move(int originX, int originY, int nextX, int nextY) {

    if (moveIsValid(originX, originY, nextX, nextY)) {
      board.makeMove(originX, originY, nextX, nextY);
    }

    board.drawBoard();
  }

  private boolean moveIsValid(int originX, int originY, int nextX, int nextY) {

    int tempX, tempY;
    Square start, end;

    tempX = originX + 2;
    tempY = originY + 2;

    if ((originX - 2) == nextX) {
      tempX = nextX - 1;
    }

    if ((originY - 2) == nextY) {
      tempY = nextY - 1;
    }
    start = board.getSquare(originX, originY);
    end = board.getSquare(nextX, nextY);
    return (start.isOccupied() && !end.isOccupied());
  }
}
