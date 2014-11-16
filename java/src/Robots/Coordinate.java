package Robots;

import java.util.Objects;

/**
 * Created by lgylym on 2014/11/16.
 */
public class Coordinate {
    int x;
    int y;

    public static Coordinate north = new Coordinate(0, 1);
    public static Coordinate south = new Coordinate(0, -1);
    public static Coordinate east = new Coordinate(1, 0);
    public static Coordinate west = new Coordinate(-1, 0);

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if(!(other instanceof Coordinate)) {
            return false;
        }
        Coordinate c = (Coordinate) other;

        if((x == c.x) && (y == c.y)) {
            return true;
        }else {
            return false;
        }
    }
}
