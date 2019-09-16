class Solution {
    public int[] sortedSquares(int[] A) {
        if(A==null) return null;
        int left = 0;
        int right = A.length-1;
        int[] res = new int[A.length];
        for(int i = 0; i<A.length; i++){
            int leftval = Math.abs(A[left]);
            int rightval = Math.abs(A[right]);
            if(leftval<=rightval){
                res[A.length-1-i] = rightval*rightval;
                right--;
            }else{
                res[A.length-1-i] = leftval*leftval;
                left++;
            }
        }
        return res;
    }
}
