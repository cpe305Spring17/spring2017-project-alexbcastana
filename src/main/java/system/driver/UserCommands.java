package system.driver;

import system.style.GameStyle;

import java.util.Scanner;

/**
 * Created by Marth on 5/18/2017.
 */
public class UserCommands {

    private GameStyle style;

    public UserCommands(GameStyle style) {
        this.style = style;
    }


    public int run() {

        String temp;
        Scanner scan = new Scanner(System.in);

        temp = scan.next();
        while (!"quit".equals(temp)) {
            interpretCommand(temp, scan);
            temp = scan.next();

        }

        return 0;

    }

    public void interpretCommand(String command, Scanner scan) {

        if ("move".equals(command) || ("Move").equals(command)) {

            moveCommand(scan);

        }
    }

    private void moveCommand(Scanner scan) {

        String coordinateStart, coordinateDest;
        int originX, originY, nextX, nextY;

        try {
            coordinateStart = scan.next();
            coordinateDest = scan.next();
        }
        catch (Exception except) {
            return;
        }

        originX = Character.getNumericValue(coordinateStart.charAt(1));
        originY = Character.getNumericValue(coordinateStart.charAt(0));

        nextX = Character.getNumericValue(coordinateDest.charAt(1));
        nextY = Character.getNumericValue(coordinateDest.charAt(0));

        style.move(originX, originY, nextX, nextY);

    }
}
