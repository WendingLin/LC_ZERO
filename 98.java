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
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}
