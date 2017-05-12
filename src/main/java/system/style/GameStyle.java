package system.style; /**
 * Created by Marthxander on 4/27/2017.
 */
import board.Board;

public abstract class GameStyle {

  private final int STARTING_PIECES = 12;
  private int timeRemaining;
  private int turnCount;
  private int rPieces;
  private int bPieces;

  public GameStyle() {
    timeRemaining = 0;
    turnCount = 0;
    rPieces = STARTING_PIECES;
    bPieces = STARTING_PIECES;
  }
  public void startGame() {
    Board board = new Board();
    board.drawBoard();
  }

  public int getTimeRemaining() {
    return timeRemaining;
  }

  public int getTurnCount() {
    return turnCount;
  }

  public int getbPieces() {
    return bPieces;
  }

  public int getrPieces() {
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
}
