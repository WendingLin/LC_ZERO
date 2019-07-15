/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ChildInfo{
    int size = 0;
    Integer lower = null;
    Integer upper = null;
    ChildInfo(){
        
    }
    
    ChildInfo(int size, Integer leftmost, Integer rightleast){
        this.size = size;
        this.lower = leftmost;
        this.upper = rightleast;
    }
}
class Solution {
    private int res = 1;
    
    private ChildInfo helper(TreeNode root){
        if(root == null)
            return new ChildInfo();

        ChildInfo left = helper(root.left);
        ChildInfo right = helper(root.right);
        if(root.left!=null && (left.size==0 || root.val <=left.upper))
            return new ChildInfo();
        if(root.right!=null && (right.size==0 || root.val >= right.lower))
            return new ChildInfo();
        int val = 1+left.size+right.size;
        res = Math.max(res, val);
        int lower = left.lower == null?root.val:left.lower;
        int upper = right.upper == null?root.val:right.upper;
        return new ChildInfo(val, lower, upper);
    }
    public int largestBSTSubtree(TreeNode root) {
        if(root==null)
            return 0;
        helper(root);
        return res;
    }
}
