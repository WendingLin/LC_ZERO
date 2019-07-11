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
    private TreeNode find(TreeNode root, TreeNode p){
        if(root==p)
            return null;
        TreeNode curr = root, left = null;
        while(curr.val!=p.val){
            if(curr.val>p.val){
                left = curr;
                curr = curr.left;
                continue;
            }else if(curr.val<p.val){
                curr = curr.right;
                continue;
            }
            break;
        }
        return left;
        
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right!=null){
            TreeNode curr = p.right;
            while(curr.left!=null){
                curr = curr.left;
            }
            return curr;
        }
        TreeNode prev = find(root, p);
        if(prev == null) return null;
        return prev;
    }
}
