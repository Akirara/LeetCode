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
    public boolean isBalanced(TreeNode root) {
    	if(root == null)
    		return true;
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) < 2)
        	return isBalanced(root.left) && isBalanced(root.right);
        else
        	return false; 
    }

    public int getHeight(TreeNode t) {
    	if(t == null) {
    		return 0;
    	}
    	else{
    		return max(getHeight(t.left), getHeight(t.right)) + 1;
    	}
    }

    public int max(int a, int b) {
    	return (a > b)?a:b;
    }
}