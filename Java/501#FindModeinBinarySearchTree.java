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
    List<Integer> l;
    Integer pre = null;
    int count = 1;
    int max = 0;
    
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        l = new ArrayList<>();
        inorder(root);
        int[] ret = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ret[i] = l.get(i);
        }
        return ret;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null) {
            if (pre.equals(root.val)) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            l.clear();
            l.add(root.val);
            max = count;
        } else if (count == max) {
            l.add(root.val);
        }
        pre = root.val;
        inorder(root.right);
    }
}