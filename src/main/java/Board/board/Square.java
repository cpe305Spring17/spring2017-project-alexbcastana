package Board.board;

/**
 * Created by Marthxander on 4/27/2017.
 */
import Board.pieces.*;

public class Square {

  private boolean isOccupied;
  private Piece piece;

  //Square on the board. 64 squares per board
  public Square(boolean isOccupied, boolean isBlack, boolean isKing) {

    if (isKing) {
      this.piece = new King(this, isBlack);
    } else {
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
    if (isOccupied) {
      return piece.getColor();
    }
    return "- ";
  }
}
