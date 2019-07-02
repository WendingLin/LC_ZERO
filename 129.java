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
  private void helper(TreeNode root, int currval) {
    if (root != null) {
      currval = currval * 10 + root.val;
      if (root.left == null && root.right == null) {
        res += currval;
      } else {
        helper(root.left, currval);
        helper(root.right, currval);
      }
    }
  }
  public int sumNumbers(TreeNode root) {
    helper(root, 0);
    return res;
  }
}
