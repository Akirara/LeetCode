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