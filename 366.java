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
  private int DFS(TreeNode root) {
    if (root == null) {
      return -1;
    }
    int depth = 1 + Math.max(DFS(root.left), DFS(root.right));
    if (depth >= res.size()) {
      res.add(new ArrayList<Integer>());
    }
    res.get(depth).add(root.val);
    return depth;
  }

  public List<List<Integer>> findLeaves(TreeNode root) {
    DFS(root);
    return res;
  }
}
