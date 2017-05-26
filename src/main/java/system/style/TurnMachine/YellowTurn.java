package system.style.TurnMachine;

import board.Board;
import board.Square;
import system.style.GameStyle;

/**
 * Created by Marth on 5/26/2017.
 */
public class YellowTurn extends TurnMachine {

    public void changeTurn(GameStyle game) {
        game.setTurn(new RedTurn());
    }

    public boolean correctTurn(Square start){
        return "Yellow".equals(start.getPiece().getFaction());
    }

    public String toString() {
        return "It is Yellow's Turn";
    }
}
