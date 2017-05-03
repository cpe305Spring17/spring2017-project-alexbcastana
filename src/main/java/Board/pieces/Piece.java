package Board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import Board.board.Square;

public abstract class Piece {
  protected Square square;


  public Piece(Square square) {

    this.square = square;
  }

  public abstract void move(String location);

  public abstract String getColor();
}
