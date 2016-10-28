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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        if(len == 0) {
        	return null;
        }

        Stack<TreeNode> sk = new Stack();
        TreeNode root = new TreeNode(postorder[len - 1]);
        TreeNode top = root;
        int i = len - 2, j = len - 1;
        boolean addToRight = true;

        sk.push(root);

        while(i >= 0) {
        	if(!sk.empty() && sk.peek().val == inorder[j]) {
        		addToRight = false;
        		top = sk.pop();
        		--j;
        	}
        	else {
        		if(addToRight) {
        			top.right = new TreeNode(postorder[i]);
        			top = top.right;
        		}
        		else {
        			addToRight = true;
        			top.left = new TreeNode(postorder[i]);
        			top = top.left;
        		}

        		sk.push(top);
        		--i;
        	}
        }

        return root;
    }
}