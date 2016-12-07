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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        if (root.left == null && root.right == null) {
            ret.add(String.valueOf(root.val));    
        } else {
            if (root.left != null) {
                List<String> lc = binaryTreePaths(root.left);
                for (String s : lc) {
                    ret.add(root.val + "->" + s);
                }
            }
            if (root.right != null) {
                List<String> rc = binaryTreePaths(root.right);
                for (String s : rc) {
                    ret.add(root.val + "->" + s);
                }
            }    
        }
        return ret;
    }
}