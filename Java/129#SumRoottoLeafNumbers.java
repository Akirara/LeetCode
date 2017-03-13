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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0, 0);
    }
    
    public int dfs(TreeNode root, int sum, int cur) {
        cur = cur * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            sum += cur;
            return sum;
        }
        if (root.left != null) {
            sum = dfs(root.left, sum, cur);
        }
        if (root.right != null) {
            sum = dfs(root.right, sum, cur);
        }
        
        return sum;
    }
}