/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        
        Node curr = head;
        while(curr!=null){
            Node temp = new Node(curr.val, curr.next, null);
            curr.next = temp;
            curr = temp.next;
        }
        curr = head;
        while(curr!=null){
            Node temp = curr.random;
            if(temp!=null) curr.next.random = temp.next;
            curr = curr.next.next;
        }
        Node root = head.next;
        curr = head;
        while(curr!=null){
            Node temp = curr.next;
            curr.next = temp.next;
            if(curr.next!=null) temp.next = curr.next.next;
            else temp.next = null;   
            curr = curr.next;
        }
        return root;
    }
}
