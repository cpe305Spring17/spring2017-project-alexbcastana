package Board.Pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import Board.Board.Square;

public class Pawn extends Piece {

  private String color;

  public Pawn(Square square, boolean isBlack) {

    super(square);
    color = "R ";
    if(isBlack) {
      color = "B ";
    }
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void move(String location) {

  }
}
