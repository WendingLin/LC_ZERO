/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    private Node DFS(Node head){
        Node curr = head;
        while(curr!=null){
            if(curr.child!=null){
                Node temp = curr.child;
                // Find the tail of the child
                while( temp.next != null ) 
                    temp = temp.next;
                // Connect tail with p.next, if it is not null
                temp.next = curr.next;  
                if( curr.next != null )  curr.next.prev = temp;
                // Connect p with p.child, and remove p.child
                curr.next = curr.child; 
                curr.child.prev = curr;
                curr.child = null;
            }else{
                curr = curr.next;
            }
        }
        return curr;
    }
    public Node flatten(Node head) {
        if(head == null) return head;
        DFS(head);
        return head;
    }
}
