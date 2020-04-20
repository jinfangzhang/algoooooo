import org.omg.PortableInterceptor.NON_EXISTENT;

import DataStruct.ListNode;

/**
 * _02_AddTwoNumber
 */
public class _02_AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            int val = add;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            add = val / 10;
            val %= 10;

            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        return res.next;
    }
}