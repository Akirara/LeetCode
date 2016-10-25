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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        if(len == 0) {
            return null;
        }
        
        TreeNode ret = new TreeNode(preorder[0]);
        
        if(len == 1) {
            return ret;
        }

        int pos = 0;
        
        while(inorder[pos] != preorder[0]) {
            ++pos;
        }

        int[] leftPre = new int[pos];
        int[] leftIn = new int[pos];

        for(int i = 0; i < pos; ++i) {
            leftPre[i] = preorder[i + 1];
            leftIn[i] = inorder[i];
        }

        ret.left = buildTree(leftPre, leftIn);

        int[] rightPre = new int[len - pos - 1];
        int[] rightIn = new int[len - pos - 1];

        for(int i = 0; i < len - pos - 1; ++i) {
            rightPre[i] = preorder[pos + i + 1];
            rightIn[i] = inorder[pos + i + 1];
        }

        ret.right = buildTree(rightPre, rightIn);

        return ret;
    }
}


public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        if(len == 0) {
            return null;
        }

        Stack<TreeNode> sk = new Stack();
        boolean addToLeft = true;
        int i = 1, j = 0;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode top = root;

        sk.push(root);

        while(i < len) {
            if(!sk.empty() && sk.peek().val == inorder[j]) {
                addToLeft = false;
                top = sk.pop();
                ++j;
            }
            else {
                if(addToLeft) {
                    top.left = new TreeNode(preorder[i]);
                    top = top.left;
                }
                else {
                    addToLeft = true;
                    top.right = new TreeNode(preorder[i]);
                    top = top.right;
                }
                
                sk.push(top);
                ++i;
            }
        }

        return root;
    }
}