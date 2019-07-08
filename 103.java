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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean re = false;
        while(queue.isEmpty()==false){
            List<Integer> temp = new LinkedList<Integer>();
            int cnt = queue.size();
            for(int i = 0; i<cnt; i++){
                TreeNode node = queue.poll();
                if(re==true){
                    temp.add(0, node.val);
                }else{
                    temp.add(node.val);
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(temp);
            re = !re;
        }
        return res;
    }
}
