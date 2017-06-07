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

  public boolean completeEnd(boolean isYellow) {

    if (isYellow) {
      System.out.println("Yellow is Victorious!");
    }
    else {
      System.out.println("Red is Victorious!");
    }
    return true;
  }

  public void completeTurn() {
    return;
  }

  public void completePieceChanges() {

    System.out.println("Remaining Red Pieces: " + rPieces);
    System.out.println("Remaining Yellow Pieces: " + yPieces);

  }
}
