/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while(l1 != null && l2 != null) {
        	int value = 0;
        	if(l1.val < l2.val) {
        		value = l1.val;
        		l1 = l1.next; 
        	}
        	else {
        		value = l2.val;
        		l2 = l2.next;
        	}
        	current.next = new ListNode(value);
        	current =current.next;
        }
        current.next = l1 != null ? l1: l2;
        return head.next;
    }
}