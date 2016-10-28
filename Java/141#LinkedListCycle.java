/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
		if(head == null) {
			return false;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;

		while(p2 != null) {
			p1 = p1.next;
			p2 = p2.next;

			if(p1 == p2) {
				return true;
			}

			if(p2 != null) {
				p2 = p2.next;
			}
		}

		return false;    
    }
}