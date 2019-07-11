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
    private void ser(TreeNode root, StringBuilder res){
        if(root==null){
            res.append("null").append(",");
            return;
        }         
        res.append(root.val).append(",");
        ser(root.left, res);
        ser(root.right, res);
    }
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder res = new StringBuilder();
        ser(root, res);
        return res.toString();
    }
    
    private TreeNode helper(String[] node, int[] counter){
        String sval = node[counter[0]];
        if(sval.equals("null")){
            counter[0]++;
            return null;
        }
        counter[0]++;
        TreeNode root = new TreeNode(Integer.valueOf(sval));
        root.left = helper(node, counter);
        root.right = helper(node, counter);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] node = data.split(",");
        int[] counter = new int[1];
        return helper(node, counter);
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
