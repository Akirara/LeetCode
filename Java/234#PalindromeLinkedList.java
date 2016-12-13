/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        if (p2 != null) {
            p1 = p1.next;
        }
        ListNode pre = null;
        while (p1 != null) {
            ListNode next = p1.next;
            p1.next = pre;
            pre = p1;
            p1 = next;
        }
        while (pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}