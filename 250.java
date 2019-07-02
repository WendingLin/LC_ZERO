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
  private boolean helper(TreeNode root) {
    if (root == null) {
      return true;
    }
    boolean left = helper(root.left);
    boolean right = helper(root.right);
    if ((left && (root.left == null || root.left.val == root.val)) &&
        (right && (root.right == null || root.right.val == root.val))) {
      res++;
      return true;
    }
    return false;
  }

  public int countUnivalSubtrees(TreeNode root) {
    helper(root);
    return res;
  }
}
