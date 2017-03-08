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
    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        
        dfs(root, sum, tmp);
        
        return res;
    }
    
    public void dfs(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(list);
                tmp.add(root.val);
                res.add(tmp);
            } else {
                return;
            }
        }
        list.add(root.val);
        dfs(root.left, sum - root.val, list);
        dfs(root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }
}