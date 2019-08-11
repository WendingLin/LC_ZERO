/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    private Node dfs(HashMap<Node, Node> map, Node ori){
        if(map.containsKey(ori)) return map.get(ori);
        Node clone = new Node(ori.val, new ArrayList<Node>());
        map.put(ori, clone);
        for(int j = 0; j<ori.neighbors.size(); j++){
            clone.neighbors.add(dfs(map, ori.neighbors.get(j)));
        }
        return clone;
    }
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        HashMap<Node, Node> map = new HashMap<>();
        return dfs(map, node);
    }
}
