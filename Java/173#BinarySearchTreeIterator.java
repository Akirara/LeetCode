/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> sk;
    
    public BSTIterator(TreeNode root) {
        sk = new Stack<TreeNode>();
        TreeNode left = root;
        while (left != null) {
            sk.push(left);
            left = left.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !sk.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = sk.pop();
        TreeNode right = top.right;
        while (right != null) {
            sk.push(right);
            right = right.left;
        }
        return top.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */