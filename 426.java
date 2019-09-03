/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    List<Node> nodes = new ArrayList<>();
    
    private void center(Node root){
        if(root == null) return;
        center(root.left);
        nodes.add(root);
        center(root.right);
    }
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        center(root);
        for(int i = 0; i<nodes.size()-1; i++){
            nodes.get(i+1).left = nodes.get(i);
            nodes.get(i).right = nodes.get(i+1);
        }
        nodes.get(0).left = nodes.get(nodes.size()-1);
        nodes.get(nodes.size()-1).right = nodes.get(0);
        return nodes.get(0);
    }
}
