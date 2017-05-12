package system.style;

import system.style.GameStyle;

/**
 * Created by Marthxander on 4/27/2017.
 */
public class ScoreMode extends GameStyle {

  private int p1Score;
  private int p2Score;

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

}
