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

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null)
      return res;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root); // ini

    while (queue.isEmpty() == false) { // each level
      Queue<TreeNode> temp = new LinkedList<TreeNode>();
      List<Integer> partres = new ArrayList<Integer>();
      for (TreeNode node : queue) {
        if (node.left != null)
          temp.offer(node.left);
        if (node.right != null)
          temp.offer(node.right);
        partres.add(node.val);
      }
      res.add(partres);
      queue = temp;
    }
    return res;
  }
}
