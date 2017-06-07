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
}
