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
    private TreeNode devide(int[] nums, int left, int right){
        if(left>right){
            return null;
        }
        int mid = left + (right-left+1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = devide(nums, left, mid-1);
        node.right = devide(nums, mid+1, right);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length==0)
            return null;
        return devide(nums, 0, nums.length-1);
    }
}
