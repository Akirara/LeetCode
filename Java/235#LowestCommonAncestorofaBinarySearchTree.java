/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int low = p.val < q.val ? p.val : q.val;
        int high = p.val + q.val - low;
        TreeNode commonAncestor = root;
        while (true) {
            int val = commonAncestor.val;
            if (val > high) {
                commonAncestor = commonAncestor.left;
            } else if (val < low) {
                commonAncestor = commonAncestor.right;
            } else {
                break;
            }
        }
        return commonAncestor;
    }
}