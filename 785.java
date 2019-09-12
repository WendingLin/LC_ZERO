class Solution {
    private boolean DFS(int[][] graph, int[] colors, boolean[] visited, int index, int color){
        if(colors[index]!=0) return colors[index]==color;
        visited[index] = true;
        colors[index] = color;
        for(int i = 0; i<graph[index].length; i++){
            if(DFS(graph, colors, visited, graph[index][i], -color)==false) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        boolean[] visited  = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(visited[i] || DFS(graph, colors, visited, i, 1)) continue;
            else return false;
        }
        return true;
    }
}
