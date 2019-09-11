class Solution {
    private void DFS(int[][] grid, int i, int j, StringBuilder code){
        grid[i][j] = -1;
        if(i-1>=0 && grid[i-1][j]==1){
            code.append("u");
            DFS(grid, i-1, j, code);
        }
        if(i+1<grid.length && grid[i+1][j]==1){
            code.append("d");
            DFS(grid, i+1, j, code);
        }
        if(j-1>=0 && grid[i][j-1]==1){
            code.append("l");
            DFS(grid, i, j-1, code);
        }
        if(j+1<grid[0].length && grid[i][j+1]==1){
            code.append("r");
            DFS(grid, i, j+1, code);
        }
        code.append("DFS");
        
    }
    public int numDistinctIslands(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        HashSet<String> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==-1 || grid[i][j]==0) continue;
                
                StringBuilder code = new StringBuilder();
                DFS(grid, i, j, code);
                if(set.contains(code.toString())==false){
                    set.add(code.toString());
                    res++;
                }
            }
        }
        return res;
    }
}
