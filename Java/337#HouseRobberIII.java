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
    public int rob(TreeNode root) {
        int[] ret = dfs(root);
        return Math.max(ret[0], ret[1]);
    }

    public int[] dfs(TreeNode node) {
        int[] ret = new int[2];
        if (node == null) {
            return ret;
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ret[1] = node.val + left[0] + right[0];
        return ret;
    }
}