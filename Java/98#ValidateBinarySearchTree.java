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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
        	return true;
        }

       	if(!isValidBST(root.left) || !isValidBST(root.right) || (root.left != null && getMaxValue(root.left) >= root.val) || (root.right != null && getMinValue(root.right) <= root.val)) {
       		return false;
       	}

        return true;
    }

    public int getMaxValue(TreeNode root) {
    	if(root.left == null) {
    		if(root.right == null) {
    			return root.val;
    		}
    		else {
    			return Math.max(root.val, getMaxValue(root.right));
    		}
    	}
    	if(root.right == null) {
    		return Math.max(root.val, getMaxValue(root.left));
    	}
    	else {
    		return Math.max(root.val, Math.max(getMaxValue(root.left), getMaxValue(root.right)));
    	}
    }

    public int getMinValue(TreeNode root) {
    	if(root.left == null) {
    		if(root.right == null) {
    			return root.val;
    		}
    		else {
    			return Math.min(root.val, getMinValue(root.right));
    		}
    	}
    	if(root.right == null) {
    		return Math.min(root.val, getMinValue(root.left));
    	}
    	else {
    		return Math.min(root.val, Math.min(getMinValue(root.left), getMinValue(root.right)));
    	}
    }
}


public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, int min, int max) {
    	if(root == null) {
    		return true;
    	}

    	if(root.val < min || root.val > max) {
    		return false;
    	}

    	if(root.val == min && root.left != null) {
    		return false;
    	}

    	if(root.val == max && root.right != null) {
    		return false;
    	}

    	return dfs(root.left, min, root.val - 1) && dfs(root.right, root.val + 1, max);
    }
}