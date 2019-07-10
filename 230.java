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
    public int kthSmallest(TreeNode root, int k) {
        int counter = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
        int res = 0;
        while(counter!=k){
            TreeNode temp = stack.pop();
            res = temp.val;
            if(temp.right!=null){
                temp = temp.right;
                while(temp!=null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            counter++;
        }
        return res;
    }
}
