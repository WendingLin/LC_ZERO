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
  private int getDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(getDepth(root.left), getDepth(root.right));
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null)
      return true;
    int left = getDepth(root.left);
    int right = getDepth(root.right);
    if (Math.abs(left - right) > 1)
      return false;

    return isBalanced(root.left) && isBalanced(root.right);
  }
}
