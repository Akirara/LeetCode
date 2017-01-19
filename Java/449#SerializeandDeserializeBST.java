/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String s = serialize(root.left);
        if (!s.equals("")) {
            sb.append(",").append(s);
        }
        s = serialize(root.right);
        if (!s.equals("")) {
            sb.append(",").append(s);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] s = data.split(",");
        int len = s.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            value[i] = Integer.parseInt(s[i]);
        }
        TreeNode root = devideAndConquer(value, 0, len);
        return root;
    }
    
    public TreeNode devideAndConquer(int[] a, int start, int end) {
        if (start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(a[start]);
        int index = start + 1;
        while (index < end && a[index] < a[start]) {
            index++;
        }
        root.left = devideAndConquer(a, start + 1, index);
        root.right = devideAndConquer(a, index, end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { // preorder
        StringBuilder sb = new StringBuilder();
        serializedfs(root, sb);
        return sb.toString();
    }
    
    private void serializedfs(TreeNode root, StringBuilder sb){
        if(root == null) return; // no "null "
        sb.append(root.val).append(" ");
        serializedfs(root.left, sb);
        serializedfs(root.right, sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] list = data.split(" ");
        TreeNode dummy = new TreeNode(0);
        deserializedfs(list, 0, dummy, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return dummy.left;
    }
    
    private int deserializedfs(String[] list, int pos, TreeNode par, boolean isleft, 
                                                        int lower, int upper){
        if(pos >= list.length) return pos;
    
        int val = Integer.valueOf(list[pos]);
        if(val < lower || val > upper) return pos-1; // have not used this pos, so minus one
        TreeNode cur = new TreeNode(val);
        
        if(isleft) par.left = cur;
        else       par.right = cur;
    
        pos = deserializedfs(list, ++pos, cur, true, lower, val);
        pos = deserializedfs(list, ++pos, cur, false, val, upper);
        return pos;
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    
    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] s = data.split(" ");
        int len = s.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            value[i] = Integer.parseInt(s[i]);
        }
        TreeNode root = devideAndConquer(value, 0, len);
        return root;
    }
    
    public TreeNode devideAndConquer(int[] a, int start, int end) {
        if (start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(a[start]);
        int index = start + 1;
        while (index < end && a[index] < a[start]) {
            index++;
        }
        root.left = devideAndConquer(a, start + 1, index);
        root.right = devideAndConquer(a, index, end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));