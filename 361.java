class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] v1 = new int[m][n];
        int[][] v2 = new int[m][n];
        int[][] v3 = new int[m][n];
        int[][] v4 = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 1; j<n; j++){
                char c = grid[i][j-1];
                if(c=='0') v1[i][j] = v1[i][j-1];
                else if(c=='E') v1[i][j] = v1[i][j-1]+1;
                else v1[i][j] = 0;
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = n-2; j>=0; j--){
                char c = grid[i][j+1];
                if(c=='0') v2[i][j] = v2[i][j+1];
                else if(c=='E') v2[i][j] = v2[i][j+1]+1;
                else v2[i][j] = 0;
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 1; j<m; j++){
                char c = grid[j-1][i];
                if(c=='0') v3[j][i] = v3[j-1][i];
                else if(c=='E') v3[j][i] = v3[j-1][i]+1;
                else v3[j][i] = 0;
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = m-2; j>=0; j--){
                char c = grid[j+1][i];
                if(c=='0') v4[j][i] = v4[j+1][i];
                else if(c=='E') v4[j][i] = v4[j+1][i]+1;
                else v4[j][i] = 0;
            }
        }
        
        int res = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '0')
                    res = Math.max(res, v1[i][j]+v2[i][j]+v3[i][j]+v4[i][j]);
            }
        }
        return res;
     }
}
