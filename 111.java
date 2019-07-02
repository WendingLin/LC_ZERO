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
  private int res = Integer.MAX_VALUE;

  private void helper(TreeNode root, int depth) {
    if (root != null) {
      depth++;
      if (root.left == null && root.right == null) {
        res = Math.min(res, depth);
      } else {
        helper(root.left, depth);
        helper(root.right, depth);
      }
    }
  }

  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    helper(root, 0);
    return res;
  }
}
