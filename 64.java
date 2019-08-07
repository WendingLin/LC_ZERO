class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 ||grid[0].length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        for(int i = 0; i<n; i++){
            count += grid[0][i];
            dp[0][i] = count;
        }
        count = 0;
        for(int i = 0; i<m; i++){
            count += grid[i][0];
            dp[i][0] = count;
        }
        
        for(int i = 1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
