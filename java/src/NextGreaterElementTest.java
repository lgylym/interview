import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class NextGreaterElementTest extends TestCase {

    public void testNextGreaterElement() throws Exception {
        NextGreaterElement nge = new NextGreaterElement();
        int[] A = {1,2,3,5,4};
        int[] B = {2,3,5,-1,-1};
        int[] result = nge.nextGreaterElement(A);
        assertArrayEquals(result, B);

        int[] C = {1,2,3,4,5};
        int[] D = {2,3,4,5,-1};
        assertArrayEquals(nge.nextGreaterElement(C), D);

        int[] E = {5,4,3,2,1};
        int[] F = {-1, -1, -1, -1, -1};
        assertArrayEquals(nge.nextGreaterElement(E), F);

    }
}