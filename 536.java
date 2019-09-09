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
    public TreeNode str2tree(String s) {
        if(s==null || s.length()==0) return null;
        Stack<TreeNode> stack = new Stack<>();
        
        int num = 0;
        boolean minus = false;
        boolean hasnum = false;
        
        TreeNode curr = null;
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='-') minus = true;
            else if(Character.isDigit(c)){
                hasnum = true;
                int val = c-'0';
                num = num*10 + val;
            }else if(c=='('){
                if(hasnum){//not right
                    int val = minus? -1*num:num;
                    TreeNode node = new TreeNode(val);
                    stack.push(node);
                    num = 0;
                    minus = false;
                    hasnum = false;
                }
            }else{
                if(hasnum){//not right
                    int val = minus? -1*num:num;
                    TreeNode node = new TreeNode(val);
                    TreeNode parent = stack.pop();
                    if(parent.left==null) parent.left = node;
                    else parent.right = node;
                    stack.push(parent);
                    num = 0;
                    minus = false;
                    hasnum = false;
                } else{
                    TreeNode node = stack.pop();
                    TreeNode parent = stack.pop();
                    if(parent.left==null) parent.left = node;
                    else parent.right = node;
                    stack.push(parent);
                }
            }
        }
        if(stack.isEmpty()){
            int val = minus? -1*num:num;
            TreeNode node = new TreeNode(val);
            return node;
        }else{
            return stack.pop();
        }
    }
}
