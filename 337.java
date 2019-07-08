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
    private int breakin(TreeNode root){
        int res = root.val;
        if(root.left!=null){
            res += skip(root.left);
        }
        if(root.right!=null){
            res += skip(root.right);
        }
        return res;
    }
    
    private int skip(TreeNode root){
        int res = 0;
        if(root.left!=null){
            res += Math.max(skip(root.left), breakin(root.left));
        }
        if(root.right!=null){
            res += Math.max(skip(root.right), breakin(root.right));
        }
        return res;
    }
    
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        
        return Math.max(breakin(root), skip(root));
    }
}
