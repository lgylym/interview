import common.LinkListNode;

/**
 * Created by lgylym on 14-11-13.
 */
public class ReverseLinkedListTest extends junit.framework.TestCase {
    public void testReverseIterative() throws Exception {
        ReverseLinkedList rll = new ReverseLinkedList();
        {
            LinkListNode n1 = new LinkListNode(1);
            LinkListNode result = rll.reverseIterative(n1);
            assertEquals(result.val, 1);
            assertNull(result.next);
        }
        {
            LinkListNode n1 = new LinkListNode(1);
            LinkListNode n2 = new LinkListNode(2);
            n1.next = n2;
            LinkListNode result = rll.reverseIterative(n1);
            assertEquals(result.val, 2);
            assertEquals(result.next.val, 1);
        }
    }


    public void testReverseRecursive() {
        ReverseLinkedList rll = new ReverseLinkedList();
        {
            LinkListNode n1 = new LinkListNode(1);
            LinkListNode result = rll.reverseRecursive(n1);
            assertEquals(result.val, 1);
            assertNull(result.next);
        }
        {
            LinkListNode n1 = new LinkListNode(1);
            LinkListNode n2 = new LinkListNode(2);
            LinkListNode n3 = new LinkListNode(3);
            n1.next = n2;
            n2.next = n3;
            LinkListNode result = rll.reverseRecursive(n1);
            assertNull(result.next.next.next);
            assertEquals(result.val, 3);
            assertEquals(result.next.val, 2);
            assertEquals(result.next.next.val, 1);

        }
    }
}
