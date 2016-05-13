/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode sum = new ListNode(0);
		ListNode head = sum;

		while(true) {
			if((l1 != null) && (l2 != null)) {
				sum.val = (l1.val + l2.val + carry) % 10;
				carry = (l1.val + l2.val + carry) / 10;
				l1 = l1.next;
				l2 = l2.next;
				if((l1 != null) || (l2 != null) || (carry == 1)) {
					sum.next = new ListNode(0);
					sum = sum.next;
				}
			}
			else if((l1 == null) && (l2 != null)) {
				sum.val = (l2.val + carry) % 10;
				carry = (l2.val + carry) / 10;
				l2 = l2.next;
				if((l2 != null) || (carry == 1)) {
					sum.next = new ListNode(0);
					sum = sum.next;
				}
			}
			else if((l1 != null) && (l2 == null)) {
				sum.val = (l1.val + carry) % 10;
				carry = (l1.val + carry) / 10;
				l1 = l1.next;
				if((l1 != null) || (carry == 1)) {
					sum.next = new ListNode(0);
					sum = sum.next;
				}
			}
			else if((l1 == null) && (l2 == null)) {
				if(carry == 1) {
					sum.val = 1;
				}
				return head;
			}
		}

    }
}