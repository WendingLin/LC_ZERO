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
  List<List<Integer>> res = new ArrayList<List<Integer>>();

  private void helper(TreeNode root, int sum, int count, List<Integer> curr) {
    if (root != null) {
      count += root.val;
      curr.add(root.val);
      if (root.left == null && root.right == null) {
        if (count == sum)
          res.add(new ArrayList<Integer>(curr));
      } else {
        helper(root.left, sum, count, curr);
        helper(root.right, sum, count, curr);
      }
      curr.remove(curr.size() - 1);
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    helper(root, sum, 0, new ArrayList<Integer>());
    return res;
  }
}
