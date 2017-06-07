/**
 * Created by Marth on 6/7/2017.
 */

import board.Board;
import org.junit.Test;
import junit.framework.TestCase;
import system.style.GameStyle;
import system.style.ScoreMode;

public class ScoreTest extends TestCase {

    public void testYellowWin() {
        GameStyle game = new ScoreMode();
        Board board = new Board();
        game.startGame(board);
        board.setRKings(1);
        board.setRLost(1);
        assertEquals(game.getRKingNum(), 0);
        assertEquals(game.getYKingNum(), 0);
    }
}
