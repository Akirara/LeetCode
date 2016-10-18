/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode ret = new ListNode(0);
    	ListNode tail = ret;
    	ListNode cur = head;
    	while(true) {
    		ListNode tmp = cur;
    		for(int i = 0; i < k; ++i) {
    			if(tmp != null) {
    				tmp = tmp.next;
    			}
    			else {
    				tail.next = cur;
    				return ret.next;
    			}
    		}
    		ListNode newTail = cur;
    		for(int i = 0; i < k; ++i) {
    			tmp = cur.next;
    			cur.next = tail.next;
    			tail.next = cur;
    			cur = tmp;
    		}
    		tail = newTail;
    		tail.next = null;
    	}
    }
}