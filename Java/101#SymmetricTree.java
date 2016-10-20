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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
        	return true;
        }

        return recurse(root.left, root.right);
    }

    public boolean recurse(TreeNode t1, TreeNode t2) {
    	if(t1 == null || t2 == null) {
    		return (t1 == t2) ? true : false;
    	}

    	if(t1.val != t2.val) {
    		return false;
    	}

    	return recurse(t1.left, t2.right) && recurse(t1.right, t2.left);
    }
}


public class Solution {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> currentLevel = new LinkedList();
        currentLevel.add(root);

        while(!currentLevel.isEmpty()) {
        	LinkedList<TreeNode> nextLevel = new LinkedList();

        	for(TreeNode node : currentLevel) {
        		if(node != null) {
        			nextLevel.add(node.left);
        			nextLevel.add(node.right);
        		}
        	}

        	while(currentLevel.size() > 1) {
        		TreeNode head = currentLevel.removeFirst();
        		TreeNode tail = currentLevel.removeLast();
        		if(head == null || tail == null) {
        			if(head != tail) {
        				return false;
        			}
        		}
        		else if(head.val != tail.val) {
        			return false;
        		}
        	}

        	currentLevel = nextLevel;
        }

        return true;
    }
}