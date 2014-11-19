package Robots;

import junit.framework.TestCase;

public class RoverTest extends TestCase {

    public void testReceiveControl() throws Exception {
        Plateau plt = Plateau.create(5, 5);
        Rover r1 = plt.addRover(0,0, 'N');
        assertEquals(r1.coordinate, new Coordinate(0,0));
        //rotate
        r1.receiveControl('R', plt);
        assertEquals(r1.direction, Coordinate.east);
        r1.receiveControl('R', plt);
        assertEquals(r1.direction, Coordinate.south);
        r1.receiveControl('L', plt);
        assertEquals(r1.direction, Coordinate.east);
        r1.receiveControl('M', plt);
        assertEquals(r1.coordinate, new Coordinate(1,0));
    }

    public void testGetStatus() throws Exception {
        Plateau plt = Plateau.create(5, 5);
        Rover r1 = plt.addRover(0,0, 'N');
        assertEquals("0 0 N", r1.getStatus());
        r1.receiveControl('M', plt);
        assertEquals("0 1 N", r1.getStatus());

        r1.receiveControl('R', plt);
        r1.receiveControl('M',plt);
        //assertEquals(Coordinate.east, r1.direction);
        assertEquals("1 1 E", r1.getStatus());
    }

    public void testMultiple() throws Exception {
        //test collision case
        Plateau plt = Plateau.create(5, 5);
        Rover r1 = plt.addRover(0,0, 'N');
        Rover r2 = plt.addRover(1,0, 'N');
        r1.receiveControl('R', plt);
        r1.receiveControl('M', plt);
        assertEquals("0 0 E", r1.getStatus());
        assertEquals("1 0 N", r2.getStatus());
    }

}