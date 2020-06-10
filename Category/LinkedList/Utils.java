package Category.LinkedList;

import java.util.ArrayList;
import java.util.List;

import DataStruct.ListNode;


/**
 * Utils
 */
public class Utils {

    public static ListNode createListNode(int from, int to) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        for (int i = from; i <= to; ++i) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return res.next;
    }

    public static void println(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer value : values) {
            sb.append(value).append("->");
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ListNode listNode = createListNode(0, 5);
        println(listNode);
    }
}