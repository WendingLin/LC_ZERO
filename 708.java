/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node node = new Node();
            node.val = insertVal;
            node.next = node;
            return node;
        }
        
        Node curr = head.next, last = head;
        while(true){
            if(curr==head || curr.val>=last.val && insertVal>=last.val && insertVal<=curr.val || curr.val<last.val && ((insertVal<=last.val && insertVal<=curr.val)||(insertVal>=last.val && insertVal>=curr.val))){
                Node node = new Node(insertVal, curr);
                last.next = node;
                break;
            }else{
                last = curr;
                curr = curr.next;
            }
        }
        
        
        return head;
    }
}
