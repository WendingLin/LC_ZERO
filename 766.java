class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return true;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i<m-1; i++){
            for(int j = 0; j<m-1-i && j+1<n; j++){
                if(matrix[i+j][j]!=matrix[i+j+1][j+1]) return false;
            }
        }
        
        for(int j = 1; j<n-1; j++){
            for(int i = 0; i<n-1-j && i+1<m ; i++){
                if(matrix[i][j+i]!=matrix[i+1][j+i+1]) return false;
            }
        }
        
        return true;
        
    }
}
