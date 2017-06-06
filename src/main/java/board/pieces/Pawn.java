package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public class Pawn extends Piece {

  private String color;


  public Pawn(Square square, boolean isYellow) {

    super(square, isYellow);
    ptValue = 10;
  }

  public void setYellow() {
    this.color = "| y |";
    this.faction = "Yellow";
  }

  public void setRed() {
    this.color = "| r |";
    this.faction = "Red";
  }

  public String getColor() {
    return color;
  }

  public String getFaction() {
    return faction;
  }
}
