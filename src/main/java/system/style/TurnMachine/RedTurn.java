package system.style.TurnMachine;

import board.Square;
import system.style.GameStyle;

/**
 * Created by Marth on 5/26/2017.
 */
public class RedTurn extends TurnMachine {

    public void changeTurn(GameStyle game) {
        game.setTurn(new YellowTurn());
    }

    public boolean correctTurn(Square start){
        return "Red".equals(start.getPiece().getFaction());
    }

    public String toString() {
        return "It is Red's Turn";
    }
}
