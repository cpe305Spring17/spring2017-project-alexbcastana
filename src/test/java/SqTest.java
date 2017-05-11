/**
 * Created by Marthxander on 5/10/2017.
 */

import Board.board.Square;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqTest
{
   @Test
   public void testIsOccupied() {
      Square square = new Square(true, true, true);
      assertTrue(square.isOccupied());
      square.setOccupied(false);
      assertFalse(square.isOccupied());
   }

}
