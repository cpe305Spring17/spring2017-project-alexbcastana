/**
 * Created by Marth on 6/7/2017.
 */

import board.Board;
import org.junit.Test;
import junit.framework.TestCase;
import system.style.GameStyle;
import system.style.StandardMode;

public class StandardTest extends TestCase {

    @Test
    public void StandardTest() {

        Board gameBoard = new Board();
        GameStyle game = new StandardMode();
        assertNotNull(game);
        assertEquals(game.getTimeRemaining(), 0);
        assertEquals(game.getTurnCount(), 0);
        assertEquals(game.getYPieces(), 12);
        assertEquals(game.getRPieces(), 12);

        game.startGame(gameBoard);

        assertNotNull(gameBoard);
    }
}
