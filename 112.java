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
  private boolean helper(TreeNode root, int sum, int count) {
    if (root == null)
      return false;
    else {
      count += root.val;

      if (root.left == null && root.right == null && count == sum)
        return true;
      else
        return helper(root.left, sum, count) || helper(root.right, sum, count);
    }
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    return helper(root, sum, 0);
  }
}
