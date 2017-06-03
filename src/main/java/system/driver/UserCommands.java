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

        else if ("combo".equals(command) || ("Combo").equals(command)) {

            comboCommand(scan);
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

        originY = correctLetter(coordinateStart.charAt(0));
        originX = Character.getNumericValue(coordinateStart.charAt(1));

        nextY = correctLetter(coordinateDest.charAt(0));
        nextX = Character.getNumericValue(coordinateDest.charAt(1));


        if (nextX < 0 || nextY < 0 || originX < 0 || originY < 0) {
            System.out.println("Invalid coordinates. Please try again.");
            return;
        }


        style.move(originX, originY, nextX, nextY);
    }

    private void comboCommand(Scanner scan) {
        int[] coordinates = new int[24];
        int count = 0;
        int limit;
        String location, token;
        Scanner scanScanner;

        location = scan.nextLine();
        scanScanner = new Scanner(location);
        while (scanScanner.hasNext()) {
            token = scanScanner.next();
            coordinates[count++] = correctLetter(token.charAt(0));
            coordinates[count++] = Character.getNumericValue(token.charAt(1));
            System.out.println(location);
        }

        limit = count;
        count = 0;

        while (count < limit) {
            if (coordinates[count] < 0 || coordinates[count] > 8) {
                System.out.println("One of the coordinates is invalid. Please try again.");
                return;
            }
            count++;
        }
        style.combo(coordinates, limit);

    }

    private int correctLetter(char letter) {

        int temp;
        boolean outOfBounds;

        letter = Character.toUpperCase(letter);
        temp = Character.getNumericValue(letter);
        temp = temp - Character.getNumericValue('A');
        outOfBounds = checkBounds(temp);
        if (outOfBounds) {
            return -1;
        }
        return temp;
    }

    private boolean checkBounds(int coordinate) {

        if (coordinate < 0 || coordinate > 8) {
            return true;
        }
        return false;
    }
}
