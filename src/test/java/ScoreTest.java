/**
 * Created by Marth on 6/7/2017.
 */

import board.Board;
import org.junit.Test;
import junit.framework.TestCase;
import system.MoveHandler;
import system.style.GameStyle;
import system.style.ScoreMode;

public class ScoreTest extends TestCase {

    public void testYellowWin() {
        ScoreMode game = new ScoreMode();
        Board board = new Board();
        game.startGame(board);
        board.setYKings(1);
        board.setRLost(1);
        assertEquals(game.getRKingNum(), 0);
        assertEquals(game.getYKingNum(), 0);
        assertEquals(game.getP1Score(), 0);
        assertEquals(game.getP2Score(), 0);
        game.getPieceChanges();
        System.out.println("P2Score = " + game.getP2Score());
        assertEquals(game.getP2Score(), 30);
    }

    public void testRedWin() {
        ScoreMode game = new ScoreMode();
        Board board = new Board();
        game.startGame(board);
        game.setYPieces(0);
        game.move(1, 1, 2, 2);
        assertEquals(game.getP1Score(), 0);
    }

    public void testYellowWinOne() {
        ScoreMode game = new ScoreMode();
        Board board = new Board();
        game.startGame(board);
        game.setRPieces(0);
        game.move(1, 1, 2, 2);
        assertEquals(game.getP1Score(), 0);
    }

    public void testMakeCombo() {
        Board board = new Board();
        board.drawBoard();
        MoveHandler handler = new MoveHandler(new Board());
        assertFalse(handler.comboCheck(0, 0, 0, 0));
    }
}
