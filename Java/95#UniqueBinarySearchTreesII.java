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
    public List<TreeNode> generateTrees(int n) {
    	List<Integer> candidate = new ArrayList();

    	for(int i = 1; i <= n; ++i) {
    		candidate.add(i);
    	}

    	List<TreeNode> ret = recurse(candidate);

    	return ret;
    }

    public List<TreeNode> recurse(List<Integer> candidate) {
    	List<TreeNode> ret = new ArrayList();

    	if(candidate.isEmpty()) {
    		return ret;
    	}

    	if(candidate.size() == 1) {
    		TreeNode tmp = new TreeNode(candidate.get(0));
    		ret.add(tmp);

    		return ret;
    	}

    	for(int i = 0, end = candidate.size(); i < end; ++i) {
    		List<Integer> l = candidate.subList(0, i);
    		List<Integer> r = candidate.subList(i + 1, end);

    		List<TreeNode> lList = recurse(l);
    		List<TreeNode> rList = recurse(r);

    		if(lList.size() == 0) {
    			for(int j = 0; j < rList.size(); ++j) {
    				TreeNode tmp = new TreeNode(candidate.get(i));
    				tmp.right = rList.get(j);
    				ret.add(tmp);
    			}
    		}
    		else if(rList.size() == 0) {
    			for(int j = 0; j < lList.size(); ++j) {
    				TreeNode tmp = new TreeNode(candidate.get(i));
    				tmp.left = lList.get(j);
    				ret.add(tmp);
    			}
    		}
    		else {
    			for(int j = 0; j < lList.size(); ++j) {
    				for(int k = 0; k < rList.size(); ++k) {
    					TreeNode tmp = new TreeNode(candidate.get(i));
    					tmp.left = lList.get(j);
    					tmp.right = rList.get(k);
    					ret.add(tmp);
    				}
    			}
    		}
    	}

    	return ret;
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
    public static List<TreeNode> generateTrees(int n) {
	    List<TreeNode>[] result = new List[n + 1];
	    result[0] = new ArrayList<TreeNode>();
	    if (n == 0) {
	        return result[0];
	    }

	    result[0].add(null);
	    for (int len = 1; len <= n; len++) {
	        result[len] = new ArrayList<TreeNode>();
	        for (int j = 0; j < len; j++) {
	            for (TreeNode nodeL : result[j]) {
	                for (TreeNode nodeR : result[len - j - 1]) {
	                    TreeNode node = new TreeNode(j + 1);
	                    node.left = nodeL;
	                    node.right = clone(nodeR, j + 1);
	                    result[len].add(node);
	                }
	            }
	        }
	    }
	    return result[n];
	}

	private static TreeNode clone(TreeNode n, int offset) {
	    if (n == null) {
	        return null;
	    }
	    TreeNode node = new TreeNode(n.val + offset);
	    node.left = clone(n.left, offset);
	    node.right = clone(n.right, offset);
	    return node;
	}
}