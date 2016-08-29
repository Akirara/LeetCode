/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        if(pre == null)
        	return pre;
        ListNode current = pre.next;
        while(current != null) {
        	if(current.val == pre.val) {
        		pre.next = current.next;
        	}
        	else {
        		pre = current;
        	}
        	current = pre.next;
        }
        
        return head;
    }
}