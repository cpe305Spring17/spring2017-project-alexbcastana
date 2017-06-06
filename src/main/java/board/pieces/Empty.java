package board.pieces;

import board.Square;

/**
 * Created by Marth on 5/26/2017.
 */
public class Empty extends Piece {

    private String color;

    public Empty(Square square) {
        super(square, false);
        ptValue = 0;
    }


    public void setYellow() {
        this.color = null;
        this.faction = "Empty";
    }

    public void setRed() {
        setYellow();
    }

    public String getFaction() {
        return faction;
    }

    public String getColor() {
        return color;
    }
}
