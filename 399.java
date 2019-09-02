class Solution {
    class Node{
        List<Edge> edges;
        String val;
        Node(String val){
            edges = new LinkedList<Edge>();
            this.val = val;
        }
    }
    class Edge{
        double val;
        Node next;
        Edge(double val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    HashMap<String, Node> map = new HashMap<>();
    
    private double DFS(Node curr, Node target, HashSet<Node> nodes){
        if(curr.edges.size()==0) return -1;
        nodes.add(curr);
        for(Edge edge:curr.edges){
            if(nodes.contains(edge.next)) continue;
            else if(edge.next == target) return edge.val;
            else{
                double res = DFS(edge.next, target, nodes);
                if(res==-1) continue;
                else return res*edge.val;
            }
        }
        return -1;
    }
    
    private double getPathVal(String a, String b){
        if(map.containsKey(a)==false || map.containsKey(b)==false) return -1;
        if(a.equals(b)) return 1;
        Node an = map.get(a), bn = map.get(b);
        return DFS(an, bn, new HashSet<Node>());
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if(queries==null || queries.size()==0) return null;
        double[] res = new double[queries.size()];
        
        for(int i = 0; i<values.length; i++){
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            Node an, bn;
            if(map.containsKey(a)) an = map.get(a);
            else{
                an = new Node(a);
                map.put(a, an);
            }
            
            if(map.containsKey(b)) bn = map.get(b);
            else{
                bn = new Node(b);
                map.put(b, bn);
            }
            
            double value = values[i];
            
            Edge edgeab = new Edge(value, bn);
            an.edges.add(edgeab);
            
            Edge edgeba = new Edge(1/value, an);
            bn.edges.add(edgeba);        
        }
        
        for(int i = 0; i<queries.size(); i++){
            res[i] = getPathVal(queries.get(i).get(0), queries.get(i).get(1));
        }
        
        return res;
    }
}
