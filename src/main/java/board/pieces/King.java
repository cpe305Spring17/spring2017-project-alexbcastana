package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public class King extends Piece{

  private String color;

  public King(Square square, boolean isYellow) {

    super(square, isYellow);
    ptValue = 30;

  }

  public void setRed() {
    this.color = "| R |";
    this.faction = "Red";
  }

  public void setYellow() {
    this.color = "| Y |";
    this.faction = "Yellow";
  }

  public String getColor() {
    return color;
  }

  public String getFaction() {
    return faction;
  }
}
