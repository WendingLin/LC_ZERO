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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean result = false;
        queue.offer(root);
        
        int find = 0;
        while(queue.isEmpty()==false){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                boolean findinpar = false;
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    queue.offer(curr.left);
                    if(curr.left.val==x || curr.left.val==y){
                        findinpar = true;
                        find++;
                    }
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                    if(curr.right.val==x || curr.right.val==y){
                        if(findinpar) return false;
                        find++;
                    }
                }
                if(find==2) return true;
            }
            if(find>0) return false;
        }
        return false;
    }
}
