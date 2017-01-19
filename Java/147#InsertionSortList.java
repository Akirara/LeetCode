/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = fakeHead;
            while (tmp.next != null && tmp.next.val <= cur.val) {
                tmp = tmp.next;
            }
            ListNode newNode = new ListNode(cur.val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            cur = cur.next;
        }
        return fakeHead.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = fakeHead;
        while (cur.next != null) {
            ListNode tmp = fakeHead;
            while (tmp.next != cur.next && tmp.next.val <= cur.next.val) {
                tmp = tmp.next;
            }
            if (tmp.next == cur.next) {
                cur = cur.next;
            } else {
                ListNode next = tmp.next;
                tmp.next = cur.next;
                cur.next = cur.next.next;
                tmp.next.next = next;
            }
        }
        return fakeHead.next;
    }
}