package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public class Pawn extends Piece {

  private String color;


  public Pawn(Square square, boolean isBlack) {

    super(square);
    color = " r ";
    faction = "Red";
    if(isBlack) {
      color = " y ";
      faction = "Yellow";
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
