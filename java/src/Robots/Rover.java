package Robots;

/**
 * Created by lgylym on 2014/11/16.
 */
public class Rover {
    Coordinate coordinate;
    Coordinate direction;
    public Rover(int x, int y, char heading) {
        coordinate = new Coordinate(x, y);
        switch (heading) {
            case 'N':
                direction = new Coordinate(0,1);
                break;
            case 'E':
                direction = new Coordinate(1,0);
                break;
            case 'S':
                direction = new Coordinate(0,-1);
                break;
            case 'W':
                direction = new Coordinate(-1,0);
                break;
            default:
                System.err.println("Illegal direction: " + heading + ", set direction to N");
                direction = Coordinate.north;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(coordinate.x + ", " + coordinate.y + " with direction ");
        sb.append(direction.x + ", " + direction.y);
        return sb.toString();
    }

    //implement "L" "R" action
    private void turn(char way) {
        switch (way) {
            case 'L':
                int tempX = direction.x;
                int tempY = direction.y;
                direction.x = -tempY;
                direction.y = tempX;
                break;
            case 'R':
                int temp1X = direction.x;
                int temp1Y = direction.y;
                direction.x = temp1Y;
                direction.y = -temp1X;
                break;
            default:
                System.err.println("Ignore illegal turn instruction: " + way);
        }
    }

    //implement "M" action
    private void move(Plateau currentPlateau) {
        int futureX = coordinate.x + direction.x;
        int futureY = coordinate.y + direction.y;
        if(currentPlateau.isLegal(futureX, futureY)) {
            currentPlateau.move(coordinate.x, coordinate.y, futureX, futureY);
            coordinate.x = futureX;
            coordinate.y = futureY;
        }else {
            System.err.println("Cannot move, illegal coordinate (" + futureX + "," + futureY + ")");
        }
    }

    public void receiveControl(char control, Plateau currentPlateau) {
        switch (control) {
            case 'M':
                move(currentPlateau);
                break;
            case 'L':
            case 'R':
                turn(control);
                break;
            default:
                System.err.println("Illegal control character ignored:" + control);
        }
    }

    /**
     * Get status in the given format, "X Y direction"
     * @return
     */
    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(coordinate.x + " " + coordinate.y + " ");
        if(direction.equals(Coordinate.north)) {
            sb.append("N");
        }else if(direction.equals(Coordinate.south)) {
            sb.append("S");
        }else if(direction.equals(Coordinate.east)) {
            sb.append("E");
        }else if(direction.equals(Coordinate.west)) {
            sb.append("W");
        }
        return sb.toString();
    }
}
