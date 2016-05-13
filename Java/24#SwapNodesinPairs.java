/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
    	if(head == null)
    		return head;
    	ListNode first = head;
    	ListNode second = first.next;
 		ListNode ret = new ListNode(0);
 		ListNode pre = ret;
 		ret.next = head;
    	while(first != null && second != null) {
    		first.next = second.next;
    		pre.next = second;
    		second.next = first;
    		pre = first;
    		first = first.next;
    		if(first != null)
    			second = first.next;
    	}
    	return ret.next;
    }
}