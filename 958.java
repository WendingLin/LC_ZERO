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
    int level = 0;
    int empty = 0;
    
    private void getLevel(TreeNode root){
        while(root.left!=null){
            level++;
            root = root.left;
        }
    }
    
    private boolean DFS(TreeNode root, int currlevel){
        if(currlevel>level) return false;
        else if(root.left!=null && root.right!=null){
            if(currlevel==level-1 && empty>0) return false;
            return DFS(root.left, currlevel+1) && DFS(root.right, currlevel+1);
        }else if(root.left==null && root.right==null){
            if(currlevel==level) return true;
            else if(currlevel==level-1 && empty<=1){
                empty = 1;
                return true;
            }
            else return false;
        }else if(root.left!=null && root.right==null){
            if(currlevel==level-1 && empty==0){
                empty = 1;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        getLevel(root);
        return DFS(root, 0);
    }
}
