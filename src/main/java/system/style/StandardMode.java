package system.style;

import board.pieces.Pawn;
import system.style.GameStyle;

/**
 * Created by Marthxander on 4/27/2017.
 */
public class StandardMode extends GameStyle {

  public StandardMode() {
    super();
  }

  public boolean endGame() {

    boolean isOver = true;

    if (rPieces == 0) {
      System.out.println("Yellow is Victorious!");
    }
    else if (yPieces == 0) {
      System.out.println("Red is Victorious!");
    }
    else {
      System.out.println(turn.toString());
      isOver = false;
    }
    return isOver;
  }

  public boolean processTurn(boolean madeChange) {

    board.drawBoard();
    getPieceChanges();
    if (!madeChange) {
      System.out.println("That command is not valid");
    }
    else {
      turn.changeTurn(this);
      incTurnCount();
    }
    return endGame();
  }
}
