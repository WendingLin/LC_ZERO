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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        if(preorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for(int i = 1; i<preorder.length; i++){
            int val = preorder[i];
            TreeNode temp = new TreeNode(val);
            if(temp.val<stack.peek().val){
                stack.peek().left = temp;
                stack.push(temp);
            }else{
                TreeNode curr = stack.pop(); //1
                while(stack.isEmpty()==false && stack.peek().val<val) curr = stack.pop();
                curr.right = temp;
                stack.push(temp);
            }
        }
        return root;
    }
}
