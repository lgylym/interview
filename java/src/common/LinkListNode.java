package common;

import java.util.ArrayList;

/**
 * Created by lgylym on 14-11-13.
 */
public class LinkListNode {
    public int val;
    public LinkListNode next;

    public LinkListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    public static ArrayList<Integer> getList(LinkListNode head) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkListNode cur = head;
        while (cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }
        return result;
    }

}
