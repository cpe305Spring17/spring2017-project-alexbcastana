/**
 * Created by Marthxander on 5/10/2017.
 */

import Board.board.Square;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.*;

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
     assertEquals(square.toString(), "B");
   }

}
