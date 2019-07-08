/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            int count = queue.size();
            int val=0;
            for(int i = 0; i<count; i++){
                TreeNode temp = queue.poll();
                val = temp.val;
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            res.add(val);
        }
        return res;
    }
}
