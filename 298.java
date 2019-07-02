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
  private void helper(TreeNode root, int last, int currval) {
    if (root != null) {
      if (root.val == last + 1) {
        currval++;
      } else {
        currval = 1;
      }
      last = root.val;
      res = Math.max(currval, res);

      if (root.left == null && root.right == null) {
        return;
      } else {
        helper(root.left, last, currval);
        helper(root.right, last, currval);
      }
    }
  }
  public int longestConsecutive(TreeNode root) {
    helper(root, Integer.MAX_VALUE, 1);
    return res;
  }
}
