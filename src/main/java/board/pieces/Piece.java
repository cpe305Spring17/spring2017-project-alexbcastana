package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public abstract class Piece {
  protected Square square;
  protected String faction;

  public Piece(Square square, boolean isBlack) {

    this.square = square;
    faction = "Red";
    if(isBlack) {
      faction = "Black";
    }
  }

  public abstract void move(String location);

  public abstract String getColor();

  public abstract String getFaction();
}
