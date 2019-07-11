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
    List<TreeNode> record = new ArrayList<TreeNode>();
    private void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        record.add(root);
        inOrder(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inOrder(root);
        int[] nums = new int[record.size()];
        for(int i = 0; i<nums.length; i++){
            nums[i] = record.get(i).val;
        }
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            record.get(i).val = nums[i];
        }
        return;
    }
}
