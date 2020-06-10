package Category.LinkedList;

import java.util.ArrayList;
import java.util.List;

import DataStruct.ListNode;

/**
 * OddEvenLinkedList
 */
public class OddEvenLinkedList {

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点
     * 和偶数节点指的是节点编号的奇偶性，而不是节点值的奇偶性。
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode oddList = new ListNode(0);
        ListNode evenList = new ListNode(0);
        ListNode oddLast = oddList;
        ListNode evenLast = evenList;
        boolean odd = true;

        while (head != null) {
            ListNode next = head.next;
            if (odd) {
                oddLast.next = head;
                oddLast = oddLast.next;
            } else {
                evenLast.next = head;
                evenLast = evenLast.next;
            }
            head.next = null;
            odd = !odd;
            head = next;
        }

        oddLast.next = evenList.next;
        return oddList.next;
    }

    public static void main(String[] args) {
        ListNode node = Utils.createListNode(1, 6);
        Utils.println(node);
        ListNode listNode = oddEvenList(node);
        Utils.println(listNode);
    }
}