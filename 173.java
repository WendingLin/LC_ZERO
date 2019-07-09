/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr =root;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode next = node.right;
        while(next!=null){
            stack.push(next);
            next = next.left;
        }
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
