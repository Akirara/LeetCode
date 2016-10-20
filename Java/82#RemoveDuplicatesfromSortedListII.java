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
        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;
        ListNode cur = head;
        while(cur != null) {
        	int count = 0;
        	while(cur.next != null && cur.val == cur.next.val) {
        		++count;
        		cur = cur.next;
        	}
        	if(count == 0) {
        		pre.next = cur;
        		pre = cur;
        	}
        	cur = cur.next;
        }
        pre.next = null;
        return fakeHead.next;
    }
}