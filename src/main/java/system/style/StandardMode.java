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

  public void endGame() {

    if (rPieces == 0) {
      System.out.println("Yellow is Victorious!");
    }
    else if (yPieces == 0) {
      System.out.println("Red is Victorious!");
    }
    else {
      System.out.println(turn.toString());
    }
  }

  public void combo(int[] coordinates, int size) {

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
        return;
      }

      if (!moveIsValid(originX, originY, nextX, nextY) ||
              !handler.comboCheck(tempX, tempY, changeX, changeY)) {
        System.out.println("Invalid move. Please try again");
        return;
      }

      tempX = nextX;
      tempY = nextY;
      permX = changeX;
      permY = changeY;
    }
    handler.makeCombo(coordinates, size);
    processTurn(true);
  }

  public void processTurn(boolean madeChange) {

    board.drawBoard();
    getPieceChanges();
    if (!madeChange) {
      System.out.println("That command is not valid");
    }
    else {
      turn.changeTurn(this);
      incTurnCount();
    }
    endGame();
  }
}
