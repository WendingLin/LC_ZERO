class Solution {
    private int m;
    private int n;
    
    private void DFS(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        DFS(grid, i-1, j);
        DFS(grid, i+1, j);
        DFS(grid, i, j+1);
        DFS(grid, i, j-1);
    }
    
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m==0) return 0;
        n = grid[0].length;
        if(n==0) return 0;
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }
}
