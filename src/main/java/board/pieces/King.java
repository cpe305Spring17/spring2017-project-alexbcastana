package board.pieces;

/**
 * Created by Marthxander on 4/27/2017.
 */
import board.Square;

public class King extends Piece{

  private String color;

  public King(Square square, boolean isBlack) {

    super(square, isBlack);
    color = " R ";
    if(isBlack) {
      color = " B ";
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

  public String getFaction() {
    return faction;
  }
}