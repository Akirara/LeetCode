/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode p1 = head;
        ListNode p2 = head;
        
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        ListNode mid = p1;
        ListNode pre = p1.next;
        
        while (pre.next != null) {
            ListNode cur = pre.next;
            pre.next = cur.next;
            cur.next = mid.next;
            mid.next = cur;
        }
        
        p1 = head;
        p2 = mid.next;
        
        while (p1 != mid) {
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }
        
        return;
    }
}