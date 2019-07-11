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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        double diff = Double.MAX_VALUE;
        TreeNode curr = root;
        while(curr!=null){
            double temp = (double)curr.val;
            if(Math.abs(temp-target)<diff){
                res = curr.val;
                diff = Math.abs(temp-target);
            }
            if(target<temp){
                curr = curr.left;
            }else if(target>temp){
                curr = curr.right;
            }else{
                return curr.val;
            }
        }
        return res;
    }
}
