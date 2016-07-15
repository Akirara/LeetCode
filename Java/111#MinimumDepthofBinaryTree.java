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
    public int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
		int depth = 1;
        List<TreeNode> list = new ArrayList();
        list.add(root);
        while(true) {
        	List<TreeNode> tmp = new ArrayList();
        	int size = list.size();
	        for(int i = 0; i < size; ++i) {
	        	TreeNode tn = list.get(i);
	        	if(tn.left == null && tn.right == null)
	        		return depth;
	        	if(tn.left != null)
	        		tmp.add(tn.left);
	        	if(tn.right != null)
	        		tmp.add(tn.right);
	        }
	        list.clear();
	        list.addAll(tmp);
	        ++depth;
	    }
    }
}



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
    public int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
		int depth = 1;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(true) {
        	int size = q.size();
	        for(int i = 0; i < size; ++i) {
	        	TreeNode tn = q.remove();
	        	if(tn.left == null && tn.right == null)
	        		return depth;
	        	if(tn.left != null)
	        		q.add(tn.left);
	        	if(tn.right != null)
	        		q.add(tn.right);
	        }
	        ++depth;
	    }
    }
}