package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public class Pawn extends Piece {

  private String color;


  public Pawn(Square square, boolean isBlack) {

    super(square, isBlack);
    color = " r ";
    if(isBlack) {
      color = " b ";
    }
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public String getFaction() {
    return faction;
  }
}
