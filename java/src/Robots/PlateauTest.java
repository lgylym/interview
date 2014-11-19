package Robots;

import junit.framework.TestCase;

public class PlateauTest extends TestCase {

//    public void testMove() throws Exception {
//        Plateau plt = Plateau.create(5, 5);
//        Rover r1 = plt.addRover(0,0, 'N');
//        r1.receiveControl('M', plt);
//        assertTrue(plt.map[0][1]);
//        assertFalse(plt.map[0][0]);
//        r1.receiveControl('M', plt);
//        assertTrue(plt.map[0][2]);
//        assertFalse(plt.map[0][1]);
//        r1.receiveControl('M', plt);
//        r1.receiveControl('M', plt);
//        r1.receiveControl('M', plt);
//        r1.receiveControl('M', plt);
//        assertTrue(plt.map[0][5]);
//        assertFalse(plt.map[0][4]);
//    }

//    public void testIsLegal() throws Exception {
//        Plateau plt = Plateau.create(5, 5);
//        Rover r1 = plt.addRover(0,0, 'N');
//        assertTrue(plt.isLegal(0,1));
//        assertFalse(plt.isLegal(0,0));
//    }

    public void testBug() throws Exception {
        Plateau plt = Plateau.create(5, 5);
        Rover r1 = plt.addRover(0,3,'W');
        assertEquals(new Coordinate(0,3),r1.coordinate);
        assertEquals(Coordinate.west, r1.direction);


        r1.receiveControl('M', plt);
        assertEquals(new Coordinate(0,3),r1.coordinate);
        assertEquals(Coordinate.west, r1.direction);
    }

    public void testIsLegal() throws Exception {
        Plateau plt = Plateau.create(5, 5);

        assertFalse(plt.isLegal(-1,3));
    }
}