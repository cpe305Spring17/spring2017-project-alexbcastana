package Board.Board;

/**
 * Created by Marthxander on 4/27/2017.
 */
import Board.Pieces.*;

public class Square {

  private boolean isOccupied;
  private Piece piece;

  public Square(boolean isOccupied, boolean isBlack, boolean isKing) {

    if(isKing) {
      this.piece = new King(this, isBlack);
    }
    else {
      this.piece = new Pawn(this, isBlack);
    }
    this.isOccupied = isOccupied;

  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public Piece getPiece() {
    return piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public void setOccupied(boolean occupied) {
    isOccupied = occupied;
  }

  @Override
  public String toString() {
    if(isOccupied) {
      return piece.getColor();
    }
    return "- ";
  }
}
