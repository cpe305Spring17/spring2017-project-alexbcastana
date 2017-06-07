package system.style; /**
 * Created by Marthxander on 4/27/2017.
 */
import board.Board;
import board.Square;
import system.MoveHandler;
import system.style.TurnMachine.RedTurn;
import system.style.TurnMachine.TurnMachine;

public abstract class GameStyle {

  private final int STARTING_PIECES = 12;
  private int timeRemaining;
  protected int rPieces;
  protected int yPieces;
  protected Board board;
  protected int turnCount;
  protected TurnMachine turn;
  protected MoveHandler handler;

  public GameStyle() {
    timeRemaining = 0;
    turnCount = 0;
    rPieces = STARTING_PIECES;
    yPieces = STARTING_PIECES;
    turn = new RedTurn();
  }
  public void startGame(Board board) {
    this.board = board;
    board.drawBoard();
    getPieceChanges();
    handler = new MoveHandler(board);
    System.out.println(turn.toString());
  }

  public int getTimeRemaining() {
    return timeRemaining;
  }

  public int getTurnCount() {
    return turnCount;
  }

  public int getYPieces() {
    return yPieces;
  }

  public int getRPieces() {
    return rPieces;
  }

  public void incTurnCount() {
    turnCount++;
  }

  public void decYPieces() {
    yPieces--;
  }

  public void decRPieces() {
    rPieces--;
  }

  public boolean move(int originX, int originY, int nextX, int nextY) {

    boolean flag = false;

    if (moveIsValid(originX, originY, nextX, nextY)) {
      flag = handler.makeMove(originX, originY, nextX, nextY);
    }
    return processTurn(flag);
  }

  protected boolean moveIsValid(int originX, int originY, int nextX, int nextY) {


    Square start, end;

    start = board.getSquare(originX, originY);
    end = board.getSquare(nextX, nextY);
    return turn.correctTurn(start) && start.isOccupied() && !end.isOccupied();
  }

  public void getPieceChanges() {
    rPieces = rPieces - board.getRLost();
    yPieces = yPieces - board.getYLost();
    completePieceChanges();
  }

  public boolean combo(int[] coordinates, int size) {

    int count = 0;
    int originX, originY, nextX, nextY, changeX, changeY, permX, permY, tempX, tempY;
    originY = tempY = coordinates[count++];
    originX = tempX = coordinates[count++];
    nextX = nextY = permX = permY = 0;

    while (count < size) {

      nextY = coordinates[count++];
      nextX = coordinates[count++];

      changeX = nextX - tempX;
      changeY = nextY - tempY;

      if (count > 5 && (permX != changeX || permY != changeY)) {
        System.out.println("Invalid Direction. Please try again");
        return false;
      }

      if (!moveIsValid(originX, originY, nextX, nextY) ||
              !handler.comboCheck(tempX, tempY, changeX, changeY)) {
        System.out.println("Invalid move. Please try again");
        return false;
      }

      tempX = nextX;
      tempY = nextY;
      permX = changeX;
      permY = changeY;
    }
    handler.makeCombo(coordinates, size);
    processTurn(true);
    return false;
  }

  public boolean processTurn(boolean madeChange) {

    board.drawBoard();
    getPieceChanges();
    if (!madeChange) {
      System.out.println("That command is not valid");
    }
    else {
      completeTurn();
      turn.changeTurn(this);
      incTurnCount();
    }
    return endGame();
  }

  public boolean endGame() {

    boolean isOver = false;

    if (rPieces == 0) {
      return completeEnd(false);
    } else if (yPieces == 0) {
      completeEnd(true);
    } else {
      System.out.println(turn.toString());
    }
    return isOver;
  }

  public TurnMachine getTurn() {
    return turn;
  }

  public void setTurn(TurnMachine turnState) {
    turn = turnState;
  }

  public abstract boolean completeEnd(boolean isYellow);

  public abstract void completeTurn();

  public abstract void completePieceChanges();
}

