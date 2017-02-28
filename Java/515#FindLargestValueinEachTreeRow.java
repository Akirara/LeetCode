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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rowMax = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        int max = Integer.MIN_VALUE;
        int size = 0;
        while (q.size() != 0) {
            max = Integer.MIN_VALUE;
            size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            rowMax.add(max);
        }
        return rowMax;
    }
}


public class Solution {
    List<Integer> res;
    int h = -1;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<Integer>();
        dfs(root, 0);
        return res;
    }
    
    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height > h) {
            res.add(root.val);
            h = height;
        } else if (root.val > res.get(height)) {
            res.set(height, root.val);
        }
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}