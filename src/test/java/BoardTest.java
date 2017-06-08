import board.Board;
import board.Square;
import junit.framework.TestCase;

/**
 * Created by Marth on 6/8/2017.
 */
public class BoardTest extends TestCase {

    public void testKingMethods() {

        Board board = new Board();
        board.setRKings(1);
        assertEquals(board.getRKings(), 1);
        board.setYKings(1);
        assertEquals(board.getYKings(), 1);
        board.setSquare(2, 2, new Square(true, true, true));
        board.checkKingLost(2, 2, true);
        assertEquals(board.getYKings(), 0);
        board.incKing(1, 1);
        assertEquals(board.getRKings(), 2);
    }
}
