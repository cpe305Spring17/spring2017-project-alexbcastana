/**
 * Created by Marth on 5/24/2017.
 */

import board.Square;
import board.pieces.Piece;
import org.junit.Test;
import junit.framework.TestCase;

public class PieceTest extends TestCase {

    @Test
    public void testGettersKing() {
        Piece myPiece;
        Square square = new Square(true, true, true);
        myPiece = square.getPiece();
        assertTrue(myPiece.getColor().equals("B"));
        assertTrue(myPiece.getFaction().equals("Black"));
    }
}
