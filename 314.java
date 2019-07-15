/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Node{
    TreeNode node;
    int pos;
    Node(TreeNode node, int pos){
        this.node = node;
        this.pos = pos;
    }
}
class Solution {
    private int left = 0;
    private int right = 0;
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while(queue.isEmpty()==false){
            int cnt = queue.size();
            for(int i = 0; i<cnt; i++){
                Node temp = queue.poll();
                int pos = temp.pos;  
                if(pos<left){
                        left = pos;
                        List<Integer> part = new ArrayList<>();
                        part.add(temp.node.val);
                        res.add(0, part);
                }else if(pos>right || (left ==0 && right == 0)){
                        right = pos;
                        List<Integer> part = new ArrayList<>();
                        part.add(temp.node.val);
                        res.add(part);
                }else{
                    res.get(pos-left).add(temp.node.val);
                }
                
                if(temp.node.left!=null){
                    queue.add(new Node(temp.node.left, pos-1));   
                }
                if(temp.node.right!=null){    
                    queue.add(new Node(temp.node.right, pos+1));
                }
            }
        }
        return res;
    }
}
