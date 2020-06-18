import DataStruct.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class _19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }

        ListNode preNode = null;
        node = head;
        for (int i = 0; i < length - n; ++i) {
            preNode = node;
            node = node.next;
        }

        if (preNode != null) {
            preNode.next = node.next;
            return head;
        } else {
            return head.next;
        }
    }

}