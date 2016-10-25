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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();

        if(root == null) {
        	return ret;
        }

        List<TreeNode> curLevel = new ArrayList();
        boolean leftToRight = true;

        curLevel.add(root);

        while(!curLevel.isEmpty()) {
        	List<Integer> value = new LinkedList();
        	List<TreeNode> nextLevel = new ArrayList();

    		for(int i = 0; i < curLevel.size(); ++i) {
    			value.add(curLevel.get(i).val);

    			if(curLevel.get(i).left != null) {
    				nextLevel.add(curLevel.get(i).left);
    			}

    			if(curLevel.get(i).right != null) {
    				nextLevel.add(curLevel.get(i).right);
    			}
    		}

    		if(!leftToRight) {
    			Collections.reverse(value);
    		}

    		ret.add(value);
    		leftToRight = !leftToRight;
    		curLevel = nextLevel;
        }

        return ret;
    }
}