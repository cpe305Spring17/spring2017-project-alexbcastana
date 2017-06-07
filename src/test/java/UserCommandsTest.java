/**
 * Created by Marth on 6/7/2017.
 */

import org.junit.Test;
import junit.framework.TestCase;
import system.driver.UserCommands;
import system.style.ScoreMode;

import java.util.Scanner;


public class UserCommandsTest extends TestCase {

    public void testMove() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "move B2 C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand(scan.next(), scan));
        scan.close();
        temp = "move AA YY";
        scan = new Scanner(temp);
        assertFalse(commands.interpretCommand(scan.next(), scan));
        scan.close();
    }

    public void testMoveFailCoordinateOne() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "move Z2 C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand(scan.next(), scan));
        scan.close();
    }

    public void testMoveFailCoordinateTwo() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "move B9 C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand(scan.next(), scan));
        scan.close();
    }

    public void testMoveFailCoordinateThree() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "move B2 Z3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand(scan.next(), scan));
        scan.close();
    }

    public void testMoveFailCoordinateFour() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "move B2 C9";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand(scan.next(), scan));
        scan.close();
    }

    public void testMoveFailCoordinateFive() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "move BY C3";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand(scan.next(), scan));
        scan.close();
    }

    public void testMoveFailCoordinateSix() {
        ScoreMode mode = new ScoreMode();
        UserCommands commands = new UserCommands(mode);
        String temp = "move B2 CY";
        Scanner scan = new Scanner(temp);
        assertFalse(commands.interpretCommand(scan.next(), scan));
        scan.close();
    }
}
