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
    private List<Integer> res = new LinkedList<>();
    private boolean compareAndInsert(int node, double target, int k){
        double diff = Math.abs((double)node-target);
        if(res.size()<k){
            res.add(node);
            return true;
        }
        int val = res.get(0);
        double comp = Math.abs((double)val-target);
        if(diff<comp){
            res.add(node);
            res.remove(0);
            return true;
        }
        return false;
    }
    private boolean helper(TreeNode root, double target, int k){
        if(root==null)
            return true;
        if(helper(root.left, target, k)==true){
            if(compareAndInsert(root.val, target, k)==true){
                return helper(root.right, target, k);
            }
        }
        return false;
    }
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        helper(root, target, k);
        return res;   
    }
}
