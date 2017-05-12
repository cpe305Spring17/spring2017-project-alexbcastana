package System.driver;

/**
 * Created by Marthxander on 4/27/2017.
 */

import java.util.*;
import System.style.*;


public class Driver {

  public static void main(String[] args) {
    GameStyle game;
    Scanner scan = new Scanner(System.in);
    String temp;

    System.out.println("What game mode would you like to play?");

    String mode = scan.next();

    if("Standard".equals(mode) || "standard".equals(mode)) {
      game = new StandardMode();
    }

    else if("Score".equals(mode) || "score".equals(mode)) {
      game = new ScoreMode();
    }

    else {
      System.out.println("Not an available game mode. Restart Application");
      return;
    }
    game.startGame();

    //temporary holder for commands. Will be moved into User/Interpreter class
    //for now it just displays board and awaits a command to shut itself down.
    temp = scan.next();
    while ("quit".equals(temp) == false) {
          temp = scan.next();
    }
  }

}
