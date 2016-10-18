/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode index = new ListNode(0);
        index.next = head;
        ListNode pre = index;
        for(int i = 1; i < m; ++i) {
        	pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next = pre.next;

        for(int i = m; i < n; ++i) {
        	next = pre.next;
        	pre.next = cur.next;
        	cur.next = cur.next.next;
        	pre.next.next = next;
        }
        return index.next;
    }
}