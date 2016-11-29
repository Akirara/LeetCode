/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null) {
            next = cur.next;
            cur.next = fakeHead.next;
            fakeHead.next = cur;
            cur = next;
        }
        return fakeHead.next;
    }
}