package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public class King extends Piece{

  private String color;

  public King(Square square, boolean isYellow) {

    super(square);
    color = "| R |";
    faction = "Red";
    if(isYellow) {
      color = "| Y |";
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
