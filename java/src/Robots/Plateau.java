package Robots;

/**
 * Created by lgylym on 14-11-16.
 */
public class Plateau {



    boolean[][] map; //map positions of rovers to the plateau

    /**
     * should use create() instead of constructor
     * @param x
     * @param y
     */
    public Plateau(int x, int y) {
        map = new boolean[x+1][y+1];
        for(int i = 0; i < x+1; i++) {
            map[i] = new boolean[y+1];
            for (int j = 0; j < y+1; j++) {
                map[i][j] = false;
            }
        }
    }

    public static Plateau create(int x, int y) {
        if((x <= 0)||(y <= 0)) {
            return null;
        }else {
            return new Plateau(x, y);
        }
    }

    public Rover addRover(int x, int y, char heading) {
        if(isLegal(x, y)) {
            Rover newRover = new Rover(x, y, heading);
            map[x][y] = true;
            return newRover;
        }else {
            System.err.println("Illegal position to add the rover: (" + x + "," + y + ")");
            return null;
        }
    }

    /**
     * mark some object moves from (x1, y1) to (x2, y2)
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void move(int x1, int y1, int x2, int y2) {
        map[x1][y1] = false;
        map[x2][y2] = true;
    }

    /**
     * return whether the certain coordinate is legal in the plateau
     * one coordinate is legal if it is within the boundary of the map and there is no other object there
     * @param x
     * @param y
     * @return
     */
    public boolean isLegal(int x, int y) {
        if ((x < map.length) && (y < map[0].length) && (map[x][y] == false)) {
            return true;
        }else {
            return false;
        }
    }

}
