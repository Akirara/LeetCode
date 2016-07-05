/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
    	ListNode pre = new ListNode(0);
    	ListNode preHead = pre;
    	ListNode next = new ListNode(0);
    	ListNode nextHead = next;
    	ListNode current = head;

    	while(current != null) {
    		if(current.val < x) {
    			pre.next = new ListNode(current.val);
    			pre = pre.next;
    		}
    		else {
    			next.next = new ListNode(current.val);
    			next = next.next;
    		}
    		current = current.next;
    	}
    	ListNode ret = preHead.next;
    	if(preHead.next != null) {
    		pre.next = nextHead.next;
    	}
    	else {
    		ret = nextHead.next;
    	}
    	next.next = null;

    	return ret;
    }
}