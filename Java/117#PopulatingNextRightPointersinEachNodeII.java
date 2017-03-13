/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        head = cur.left;
                    } else {
                        pre.next = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (head == null) {
                        head = cur.right;
                    } else {
                        pre.next = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            
            cur = head;
            head = null;
            pre = null;
        }
    }
}