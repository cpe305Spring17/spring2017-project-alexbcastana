package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public abstract class Piece {
  protected Square square;
  protected String faction;
  protected int ptValue;

  public Piece(Square square, boolean isYellow) {

    this.square = square;
    setRed();
    if (isYellow) {
      setYellow();
    }

  }

  public abstract void setRed();

  public abstract void setYellow();

  public abstract String getColor();

  public abstract String getFaction();

  public int getPtValue() {
    return ptValue;
  }
}
