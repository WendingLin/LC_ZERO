class Solution {
    private void swap(int[][] matrix, int posx1, int posy1, int posx2, int posy2){
        int temp = matrix[posx1][posy1];
        matrix[posx1][posy1] = matrix[posx2][posy2];
        matrix[posx2][posy2] = temp;
    }
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==1) return;
        int n = matrix.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n-i; j++){
                swap(matrix, i, j, n-1-j, n-1-i);
            }
        }
        for(int i = 0; i<n/2; i++){
            for(int j = 0; j<n; j++){
                swap(matrix, i, j, n-1-i, j);
            }
        }
        return;
    }
}
