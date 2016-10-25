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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        
        if(root == null) {
        	return ret;
        }

        List<TreeNode> level = new ArrayList();
        level.add(root);

        while(!level.isEmpty()) {
        	List<Integer> value = new ArrayList();
        	List<TreeNode> nextLevel = new ArrayList();

        	for(TreeNode node : level) {
        		value.add(node.val);

        		if(node.left != null) {
        			nextLevel.add(node.left);
        		}

        		if(node.right != null) {
        			nextLevel.add(node.right);
        		}
        	}

        	ret.add(0, value);
        	level = nextLevel;
        }

        return ret;
    }
}