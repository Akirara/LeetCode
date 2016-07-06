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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null)
        	return ret;
        List<TreeNode> listNode = new ArrayList<TreeNode>();
        listNode.add(root);
        while(!listNode.isEmpty()) {
        	List<Integer> listVal = new ArrayList<Integer>();
        	List<TreeNode> tmp = new ArrayList<TreeNode>();
        	for(int i = 0; i < listNode.size(); i++) {
        		TreeNode node = listNode.get(i);
        		listVal.add(node.val);
        		if(node.left != null)
        			tmp.add(node.left);
        		if(node.right != null)
        			tmp.add(node.right);
        	}
        	ret.add(listVal);
        	listNode.clear();
        	listNode.addAll(tmp);
        }
        return ret;
    }
}