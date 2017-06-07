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

    }
}
