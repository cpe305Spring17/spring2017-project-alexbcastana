package System.Driver;

/**
 * Created by Marthxander on 4/27/2017.
 */

import java.util.*;
import java.io.*;
import System.GameMode.*;


public class Driver {

  public static void main(String[] args) {
    GameStyle game;
    Scanner scan = new Scanner(System.in);

    System.out.println("What game mode would you like to play?");

    String mode = scan.next();

    if(mode.equals("Standard") || mode.equals("standard")) {
      game = new StandardMode();
    }

    else if(mode.equals("Score") || mode.equals("score")) {
      game = new ScoreMode();
    }

    else {
      System.out.println("Not an available game mode. Restart Application");
      return;
    }
    game.startGame();
  }

}
