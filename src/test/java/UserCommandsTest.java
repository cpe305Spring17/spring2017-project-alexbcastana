/**
 * Created by Marth on 6/7/2017.
 */

import board.Board;
import org.junit.Test;
import junit.framework.TestCase;
import system.driver.Driver;
import system.driver.UserCommands;
import system.style.ScoreMode;

import java.util.Scanner;


public class UserCommandsTest extends TestCase {


    public void testMove() {
        ScoreMode mode = new ScoreMode();
        mode.startGame(new Board());
        UserCommands commands = new UserCommands(mode);
        String temp = "B2 C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
        temp = "AA YY";
        scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateOne() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "Z2 C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateTwo() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "B9 C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateThree() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "B2 Z3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateFour() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "B2 C9";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateFive() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "BY C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateSix() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "B2 CY";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateSeven() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "+2 C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateEight() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "B+ C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateNine() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "B2 +3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testMoveFailCoordinateTen() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "B2 C+";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
    }

    public void testComboFailCoordinateOne() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        mode.startGame(new Board());
        String temp = "B2 C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        temp = "A5 B4";
        scan.close();
        scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
        temp = "D2 E3";
        scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
        temp = "G5 F4";
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
        temp = "F0 E1";
        scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("move", scan));
        scan.close();
        temp = "B4 D2 F0";
        scan = new Scanner(temp);
        assertFalse(commands.interpretCommand("Combo", scan));
        scan.close();
        assertEquals(mode.getP1Score(), 0);
        assertEquals(mode.getP2Score(), 40);
    }


}
