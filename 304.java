class NumMatrix {
    int m;
    int n;
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix.length>0 && matrix[0].length>0){
            m = matrix.length;
            n = matrix[0].length;
            sum = new int[m][n];
            for(int i = 0; i<m; i++){
                int val = 0;
                for(int j = 0; j<n; j++){
                    val += matrix[i][j];
                    sum[i][j] = val;
                    if(i>0) sum[i][j] += sum[i-1][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = sum[row2][col2];
        if(row1>0 && col1>0){
            res = res - sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
        }else if(row1==0 && col1>0){
            res = res - sum[row2][col1-1];
        }else if(row1>0 && col1==0){
            res = res - sum[row1-1][col2];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
