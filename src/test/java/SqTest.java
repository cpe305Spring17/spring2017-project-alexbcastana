/**
 * Created by Marthxander on 5/10/2017.
 */

import board.Square;
import board.pieces.Pawn;
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
     assertEquals(square.toString(), "| Y |");
   }

   @Test
   public void testGetPiece() {
      Square square = new Square(true, true, true);
      assertTrue(square.getPiece() != null);
      square.setPiece(new Pawn(square, true));
      assertTrue(square.getPiece() instanceof Pawn);
   }

   @Test
   public void testKingMe() {
      Square square = new Square(true, true, false);
      assertTrue(square.kingMe(0));
      assertFalse(square.kingMe(7));
      square = new Square(true, false, false);
      assertFalse(square.kingMe(0));
      assertTrue(square.kingMe(7));
   }
}
