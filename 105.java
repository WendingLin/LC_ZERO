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
    private TreeNode helper(int[] preorder, int[] inorder, int prepos, int instart, int inend){
        if(prepos>=preorder.length || inend<instart) return null;
        TreeNode node = new TreeNode(preorder[prepos]);
        int split = 0;
        for(int i = instart; i<=inend; i++){
            if(inorder[i]==node.val){
                split = i;
                break;
            }
        }
        
        node.left = helper(preorder, inorder, prepos+1, instart, split-1);
        node.right = helper(preorder, inorder, prepos+split-instart+1, split+1, inend);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length);
    }
}
