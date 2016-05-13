/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode p = head;
        ListNode q = new ListNode(0);
        q.next = head;
        ListNode ret = q.next;

        while((n > 0) && (p != null)) {
        	p = p.next;
        	n--;
        }

        if(p == null)
        	return head.next;

        while(p != null) {
        	p = p.next;
        	q = q.next;
        }

        q.next = q.next.next;

        return ret;
    }
}