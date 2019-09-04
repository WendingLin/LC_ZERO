class Solution {
    private int checkAround(int[][] grid, int i, int j){
        if(grid[i][j]==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        if(i-1<0 || grid[i-1][j]==0) res++;   
        if(i+1>=m || grid[i+1][j]==0) res++;
        if(j-1<0 || grid[i][j-1]==0) res++;   
        if(j+1>=n || grid[i][j+1]==0) res++;
        return res;  
    }
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                res += checkAround(grid, i, j);
            }
                
        }
        return res;
    }
}
