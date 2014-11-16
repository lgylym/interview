package Robots;

import junit.framework.TestCase;

public class CoordinateTest extends TestCase {

    public void testEquals() throws Exception {
        Coordinate c1 = new Coordinate(0,1);
        Coordinate c2 = c1;
        assertTrue(c1.equals(c2));
        Coordinate c3 = new Coordinate(1,0);
        assertFalse(c1.equals(c3));
        Coordinate c4 = new Coordinate(0,1);
        assertTrue(c1.equals(c4));
    }
}