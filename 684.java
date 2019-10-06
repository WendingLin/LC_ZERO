class Solution {
    private boolean dfs(HashMap<Integer, List<Integer>> map, int curr, int target, int prev){
        if(map.get(curr)==null) return false;
        for(int i = 0; i<map.get(curr).size(); i++){
            if(map.get(curr).get(i)==prev) continue;
            else if(map.get(curr).get(i)==target) return true;
            else if(dfs(map, map.get(curr).get(i), target, curr)) return true;
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<edges.length; i++){
            if(dfs(map, edges[i][0], edges[i][1], -1)) return edges[i];
            if(map.containsKey(edges[i][0])==false){
                map.put(edges[i][0], new ArrayList<Integer>());
            }
            if(map.containsKey(edges[i][1])==false){
                map.put(edges[i][1], new ArrayList<Integer>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
            
        }
        
        return null;
    }
}
