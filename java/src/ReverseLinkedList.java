import common.LinkListNode;

/**
 * Created by lgylym on 14-11-13.
 * http://leetcode.com/2010/04/reversing-linked-list-iteratively-and.html
 */

public class ReverseLinkedList {
    /**
     * Reverse the list iteratively.
     * Reverse is done by examining the links one by one.
     * @param head
     * @return
     */
    public LinkListNode reverseIterative(LinkListNode head) {
        LinkListNode lnode = null; // left part of the link
        LinkListNode rnode = head; // right part of the link
        LinkListNode nextRnode; // right part of the next link

        while (rnode != null) {
            nextRnode = rnode.next;
            rnode.next = lnode;
            lnode = rnode;
            rnode = nextRnode;
        }
        return lnode;
    }

    /**
     * Do the reverse recursively.
     * @param head
     * @return
     */
    public LinkListNode reverseRecursive(LinkListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkListNode tail = head.next;
        head.next = null;
        LinkListNode newHead = reverseRecursive(tail);
        tail.next = head;
        return newHead;
    }


    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        LinkListNode n1 = new LinkListNode(1);
        LinkListNode n2 = new LinkListNode(2);
        n1.next = n2;
        LinkListNode result = rll.reverseIterative(n1);
        System.out.print(result);
        System.out.print(result.next);
    }
}
