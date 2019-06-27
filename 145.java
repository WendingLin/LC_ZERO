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
  List<Integer> li = new ArrayList<Integer>();
  public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null)
      return li;
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    li.add(root.val);
    return li;
  }
}
