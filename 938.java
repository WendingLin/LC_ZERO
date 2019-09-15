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
    int res = 0;
    private void helper(TreeNode root, int L, int R, int min, int max){
        if(root==null) return;
        int val = root.val;
        if(val>=L&&val<=R){
            res+=val;
            helper(root.left, L, R, min, Math.min(max, val));
            helper(root.right, L, R, Math.max(min,val), max);
        }else{
            if(val<L && max>=L) helper(root.right, L, R, Math.max(min,val), max);
            else if(val>R && min<=R) helper(root.left, L, R, min, Math.min(max, val));
            else return;
        }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return res;
    }
}
