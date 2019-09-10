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
    int max=0;
    private int DFS(TreeNode curr){
        if(curr==null) return 0;
        int left = DFS(curr.left);
        int right = DFS(curr.right);
        max = Math.max(left+right, max);
        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int left = DFS(root.left);
        int right = DFS(root.right);
        max = Math.max(left+right, max);
        return max;
    }
}
