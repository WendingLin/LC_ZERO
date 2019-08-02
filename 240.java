class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, column = 0;
        while(row<m && matrix[row][0]<=target) row++;
        while(column<n && matrix[0][column]<=target) column++;
        
        for(int i = 0; i<row; i++){
            int left = 0;
            int right = column-1;
            while(left<=right){
                int mid = left + (right-left)/2;
                int val = matrix[i][mid];
                if(val==target) return true;
                else if(val>target) right = mid-1;
                else left = mid+1;
            }
        }
        return false;
    }
}
