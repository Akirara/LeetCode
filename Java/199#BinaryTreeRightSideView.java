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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int len = q.size();
        while (len != 0) {
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.poll();
                if (i == 0) {
                    ret.add(cur.val);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }
            len = q.size();
        }
        return ret;
    }
}