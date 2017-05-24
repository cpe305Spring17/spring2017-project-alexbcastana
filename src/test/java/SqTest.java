/**
 * Created by Marthxander on 5/10/2017.
 */

import board.Square;
import board.pieces.Piece;
import org.junit.Test;
import junit.framework.TestCase;

public class SqTest extends TestCase
{
   @Test
   public void testIsOccupied() {
      Square square = new Square(true, true, true);
      assertTrue(square.isOccupied());
      square.setOccupied(false);
      assertFalse(square.isOccupied());
   }

   @Test
   public void testPiece() {
     Square square = new Square(true, true, true);
     assertEquals(square.toString(), " B ");
   }

   @Test
   public void testGetPiece() {
      Piece myPiece;
      boolean test = false;
      Square square = new Square(true, true, true);
      myPiece = square.getPiece();
      assertTrue(myPiece.getColor().equals("b"));
      assertTrue((myPiece.getFaction().equals("Black")));
   }
}
