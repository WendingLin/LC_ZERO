class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] res = new int[m*n];
        int count = 0;
        int r = 0, c = 0;
        for(int i = 0; i<m*n; i++){
            res[count++] = matrix[r][c];
            if((r+c)%2==0){
                if(c==n-1) r++;
                else if(r==0) c++;
                else{
                    r--;
                    c++;
                }
            }else{
                if(r==m-1) c++;
                else if(c==0) r++;
                else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
