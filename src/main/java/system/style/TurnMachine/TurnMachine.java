package system.style.TurnMachine;

import board.Board;
import board.Square;
import system.style.GameStyle;

/**
 * Created by Marth on 5/26/2017.
 */
public abstract class TurnMachine {

    public abstract void changeTurn(GameStyle game);

    public abstract boolean correctTurn(Square start);

    public abstract String toString();
}
