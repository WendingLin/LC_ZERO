/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    private Queue<Node> queue= new LinkedList<Node>();
    public Node connect(Node root) {
        if(root==null)
            return root;
        queue.offer(root);
        while(queue.isEmpty()==false){
            int cnt = queue.size();
            for(int i = 0; i<cnt; i++){
                Node temp = queue.poll();
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
                if(i!=cnt-1){
                    temp.next = queue.peek();
                }
            }
        }
        return root;
    }
}
