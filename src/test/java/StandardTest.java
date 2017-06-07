/**
 * Created by Marth on 6/7/2017.
 */

import board.Board;
import org.junit.Test;
import junit.framework.TestCase;
import system.style.GameStyle;
import system.style.StandardMode;
import system.style.TurnMachine.RedTurn;

public class StandardTest extends TestCase {

    public void testStandardSetUp() {
        Board gameBoard = new Board();
        GameStyle game = new StandardMode();
        assertNotNull(game);
        assertTrue(game.getTurn() instanceof RedTurn);
        assertEquals(game.getTimeRemaining(), 0);
        assertEquals(game.getTurnCount(), 0);
        assertEquals(game.getYPieces(), 12);
        assertEquals(game.getRPieces(), 12);

        assertFalse(game.processTurn(false));
        game.setRPieces(0);
        assertTrue(game.endGame());

        game.startGame(gameBoard);

        assertNotNull(gameBoard);
    }

    public void testStandardMove() {
        Board gameBoard = new Board();
        GameStyle game = new StandardMode();
        game.startGame(gameBoard);
        assertFalse(game.move(0, 0, 0, 0));
        assertFalse(game.move(7, 0, 0, 0));
        assertFalse(game.move(1, 1, 2, 3));
        assertFalse(game.move(1, 1, 2, 2));

        game.setYPieces(0);
        assertTrue(game.endGame());
    }
}
