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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ret = 0;
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    ret = node.val;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return ret;
    }
}


public class Solution {
    int ret = 0;
    int h = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ret;
    }
    
    public void dfs(TreeNode root, int height) {
        if (h < height) {
            ret = root.val;
            h = height;
        }
        if (root.left != null) {
            dfs(root.left, height + 1);
        }
        if (root.right != null) {
            dfs(root.right, height + 1);
        }
    }
}