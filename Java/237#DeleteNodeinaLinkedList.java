/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode current = node;
        while (true) {
            current.val = current.next.val;
            if (current.next.next == null) {
                current.next = null;
                break;
            } else {
                current = current.next;
            }
        }
    }
}