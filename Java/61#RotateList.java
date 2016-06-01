/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
		ListNode ret = head;
		if(head == null)
			return ret;
		ListNode tmp = head;
		int len = 0;
		while(tmp != null) {
			len++;
			tmp = tmp.next;
		}
		k = k % len;
		if(k == 0)
			return ret;
		ListNode p = head;
		ListNode q = head;
		for(int i = 0; i < k; i++) {
			p = p.next;
		}
		while(p.next != null) {
			p = p.next;
			q = q.next;
		}
		ret = q.next;
		p.next = head;
        q.next = null;

        return ret;
    }
}