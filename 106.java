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
    private TreeNode helper(int[] postorder, int[] inorder, int postpos, int instart, int inend){
        if(postpos<0 || inend<instart) return null;
        TreeNode node = new TreeNode(postorder[postpos]);
        int split = 0;
        for(int i = instart; i<=inend; i++){
            if(inorder[i]==node.val){
                split = i;
                break;
            }
        }
        
        node.left = helper(postorder, inorder, postpos-1-(inend-split), instart, split-1);
        node.right = helper(postorder, inorder, postpos-1, split+1, inend);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder, inorder, postorder.length-1, 0, inorder.length-1);
    }
}
