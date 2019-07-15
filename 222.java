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
    private int count = 0;
    private int level = 0;
    private void findlevel(TreeNode root){
        if(root.left!=null){
            count += Math.pow(2, level++);
            findlevel(root.left);
        }
        return;
    }
    private void traverse(TreeNode root, int h){
        if(h==level-1){
            if(root.left!=null) count++;
            if(root.right!=null) count++;
            return;
        }
        traverse(root.left, h+1);
        traverse(root.right, h+1);
    }
    public int countNodes(TreeNode root) {
        if(root==null)
            return count;
        findlevel(root);
        if(level == 0)
            return 1;
        traverse(root, 0);
        return count;
    }
}
