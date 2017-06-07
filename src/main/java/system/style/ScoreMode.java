package system.style;

import system.style.GameStyle;

/**
 * Created by Marthxander on 4/27/2017.
 */

public class ScoreMode extends GameStyle {

  private int p1Score;
  private int p2Score;
  private final int PAWN_SCORE = 10;
  private final int KING_SCORE = 30;


  public ScoreMode() {
    super();
    p1Score = 0;
    p2Score = 0;
  }


  public int getP1Score() {
    return p1Score;
  }

  public int getP2Score() {
    return p2Score;
  }

  public boolean completeEnd(boolean isYellow) {

    if (p1Score > p2Score) {
      System.out.println("Yellow is victorious with a score of: " + p2Score);
    }
    else {
      System.out.println("Red is victorious with a score of: " + p1Score);
    }
    return true;
  }

  public void completeTurn() {
    System.out.println("Red's current score: " + p1Score);
    System.out.println("Yellow's current score: " + p2Score);
  }

  public void completePieceChanges() {
    int lossY, lossR, tempY, tempR;
    tempY = board.getYKings();
    tempR = board.getRKings();
    lossY = board.getYLost();
    lossR = board.getRLost();

    p1Score += calculateScore(lossY, tempY);
    p2Score += calculateScore(lossR, tempR);

    System.out.println("Remaining Red Pieces: " + rPieces);
    System.out.println("Remaining Yellow Pieces: " + yPieces);

  }

  private int calculateScore(int loss, int kings) {

    int totalScore = 0;
    int temp = kings + loss;

    totalScore += PAWN_SCORE * temp;

    totalScore += KING_SCORE * kings;

    if (loss > 1) {
      totalScore *= 2;
    }

    return totalScore;

  }

}
