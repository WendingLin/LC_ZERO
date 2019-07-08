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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            List<Integer> temp = new ArrayList<Integer>();
            int cnt = queue.size();
            for(int i = 0; i<cnt; i++){
                TreeNode out = queue.poll();
                temp.add(out.val);
                if(out.left!=null) queue.add(out.left);
                if(out.right!=null) queue.add(out.right);
            }
            res.add(0, temp);
        }
        return res;
    }
}
