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
    private void serHelper(TreeNode root, StringBuilder sb){
        if(root==null) sb.append("N").append(",");
        else{
            sb.append(root.val).append(",");
            serHelper(root.left, sb);
            serHelper(root.right, sb);
        }
    }
    
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        serHelper(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    private TreeNode desHelper(Queue<String> list){
        String val = list.poll();
        if(val.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = desHelper(list);
        root.right = desHelper(list);
        return root;
    }
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0 || data.equals("N")) return null;
        String[] split = data.split(",");
        Queue<String> list = new LinkedList<>();
        for(String s:split) list.offer(s);
        TreeNode root = desHelper(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
