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
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null)
      return li;
    inorderTraversal(root.left);
    li.add(root.val);
    inorderTraversal(root.right);
    return li;
  }
}
