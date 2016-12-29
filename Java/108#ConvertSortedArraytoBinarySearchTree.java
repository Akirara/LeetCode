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
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    public TreeNode constructBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        } else if (low == high) {
            return new TreeNode(nums[low]);
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, low, mid - 1);
        root.right = constructBST(nums, mid + 1, high);
        return root;
    }
}


public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if ( len == 0 ) { return null; }
        TreeNode head = new TreeNode(0); 
        Stack<TreeNode> nodeStack       = new Stack<TreeNode>() {{ push(head);  }};
        Stack<Integer>  leftIndexStack  = new Stack<Integer>()  {{ push(0);     }};
        Stack<Integer>  rightIndexStack = new Stack<Integer>()  {{ push(len-1); }};
        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2;
            currNode.val = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);  
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }
}