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
  List<String> res = new ArrayList<String>();
  private void helper(String currpath, TreeNode root, boolean first) {
    if (root == null)
      return;
    else {
      if (first == false)
        currpath += "->" + root.val;
      if (root.left == null && root.right == null) {
        res.add(currpath);
      } else {
        helper(currpath, root.left, false);
        helper(currpath, root.right, false);
      }
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null)
      return res;
    helper(String.valueOf(root.val), root, true);
    return res;
  }
}
