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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> sk = new Stack<TreeNode>();
        while (root != null) {
            sk.add(root);
            root = root.left;
        }
        int count = 0;
        while (!sk.empty()) {
            if (++count == k) {
                return sk.peek().val;
            }
            TreeNode right = sk.pop().right;
            while (right != null) {
                sk.push(right);
                right = right.left;
            }
        }
        return 0;
    }
}


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
    public int kthSmallest(TreeNode root, int k) {
        int num = countNodes(root.left);
        if (num >= k) {
            return kthSmallest(root.left, k);
        } else if (num < k - 1) {
            return kthSmallest(root.right, k - num - 1);
        }
        return root.val;
    }
    
    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return countNodes(node.left) + countNodes(node.right) + 1;
    }
}


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
    int count = 0;
    int ret = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return ret;
    }
    
    public void dfs(TreeNode node) {
        if (node.left != null) {
            dfs(node.left);
        }
        if (--count == 0) {
            ret = node.val;
            return;
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }
}