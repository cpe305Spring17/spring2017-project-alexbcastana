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
        boolean end = false;
        Scanner scan = new Scanner(System.in);

        temp = scan.next();
        while (!"quit".equals(temp) && !end) {
            end = interpretCommand(temp, scan);
            temp = scan.next();
        }

        return 0;

    }

    public boolean interpretCommand(String command, Scanner scan) {

        if ("move".equals(command) || ("Move").equals(command)) {

            return moveCommand(scan);

        }

        else if ("combo".equals(command) || ("Combo").equals(command)) {

            return comboCommand(scan);
        }
        return false;
    }

    private boolean moveCommand(Scanner scan) {

        String coordinateStart, coordinateDest;
        int originX, originY, nextX, nextY;

        try {
            coordinateStart = scan.next();
            coordinateDest = scan.next();

            originY = correctLetter(coordinateStart.charAt(0));
            originX = Character.getNumericValue(coordinateStart.charAt(1));

            nextY = correctLetter(coordinateDest.charAt(0));
            nextX = Character.getNumericValue(coordinateDest.charAt(1));
        }
        catch (Exception except) {
            System.out.println("Invalid Coordinates. Please try again.");
            return false;
        }

        if (nextX < 0 || nextY < 0 || originX < 0 || originY < 0) {
            System.out.println("Invalid coordinates. Please try again.");
            return false;
        }


        return style.move(originX, originY, nextX, nextY);
    }

    private boolean comboCommand(Scanner scan) {
        int[] coordinates = new int[24];
        int count = 0;
        int limit = 0;
        String location, token;
        Scanner scanScanner;
        scanScanner = new Scanner(System.in);

        try {
            location = scan.nextLine();
            scanScanner = new Scanner(location);
            while (scanScanner.hasNext()) {
                token = scanScanner.next();
                coordinates[count++] = correctLetter(token.charAt(0));
                coordinates[count++] = Character.getNumericValue(token.charAt(1));
            }
            scanScanner.close();
            limit = count;
            count = 0;
        }
        catch (Exception e) {
            System.out.println("At least one coordinate is invalid. Please try again.");
            scanScanner.close();
            return false;
        }

        while (count < limit) {
            if (coordinates[count] < 0 || coordinates[count] > 8) {
                System.out.println("One of the coordinates is invalid. Please try again.");
                return false;
            }
            count++;
        }
        return style.combo(coordinates, limit);

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
