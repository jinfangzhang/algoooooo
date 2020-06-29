import java.util.ArrayList;
import java.util.Collections;

import DataStruct.ListNode;

/**
 * _23_MergeKSortedLists
 */
/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class _23_MergeKSortedLists {

    public ListNode mergeKLists(final ListNode[] lists) {
        ArrayList<ListNode> listNodeList = new ArrayList<>();
        if (lists == null || lists.length == 0)
            return null;
        
        Collections.addAll(listNodeList, lists);

        while (listNodeList.size() != 1) {
            final ListNode listNode1 = listNodeList.get(0);
            final ListNode listNode2 = listNodeList.get(1);
            final ListNode mergeListNode = mergeList(listNode1, listNode2);

            listNodeList.remove(listNode1);
            listNodeList.remove(listNode2);
            listNodeList.add(mergeListNode);
        }

        return listNodeList.get(0);
    }

    public ListNode mergeList(final ListNode list1, final ListNode list2) {
        final ListNode res = new ListNode(0);
        ListNode pRes = res, pList1 = list1, pList2 = list2;
        while (pList1 != null && pList2 != null) {
            if (pList1.val <= pList2.val) {
                pRes.next = new ListNode(pList1.val);
                pList1 = pList1.next;
            } else {
                pRes.next = new ListNode((pList2.val));
                pList2 = pList2.next;
            }
            pRes = pRes.next;
        }

        while (pList1 != null) {
            pRes.next = new ListNode(pList1.val);
            pRes = pRes.next;
            pList1 = pList1.next;
        }

        while (pList2 != null) {
            pRes.next = new ListNode(pList2.val);
            pRes = pRes.next;
            pList2 = pList2.next;
        }
        return res.next;
    }
}