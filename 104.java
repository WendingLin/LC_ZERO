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
  private int res = 0;

  private void helper(TreeNode root, int depth) {
    if (root != null) {
      depth++;
      res = Math.max(depth, res);
      helper(root.left, depth);
      helper(root.right, depth);
    }
  }

  public int maxDepth(TreeNode root) {
    helper(root, 0);
    return res;
  }
}
