// inorder tranversal
public class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode pre = null;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        
        return minDiff;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre.val);
        }
        
        pre = root;
        inorder(root.right);
    }
}


// pass left bound and right bound
public class Solution {
    int minDiff = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        return minDiff;
    }
    
    public void helper(TreeNode cur, int lb, int rb) {
        if (cur == null) {
            return;
        }
        
        if (lb != Integer.MIN_VALUE) {
            minDiff = Math.min(minDiff, cur.val - lb);
        }
        if (rb != Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff, rb - cur.val);
        }
        
        helper(cur.left, lb, cur.val);
        helper(cur.right, cur.val, rb);
    }
}