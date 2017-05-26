package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public abstract class Piece {
  protected Square square;
  protected String faction;

  public Piece(Square square) {

    this.square = square;

  }

  public abstract String getColor();

  public abstract String getFaction();
}
