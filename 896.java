class Solution {
    public boolean isMonotonic(int[] A) {
        if(A==null || A.length==0 || A.length==1) return true;
        Boolean increase = null;
        for(int i = 0; i<A.length-1; i++){
            if(A[i+1]==A[i]) continue;
            if(increase==null) increase = A[i+1]>A[i]?true:false;
            else if(A[i+1]>A[i]==increase) continue;
            else return false;
        }
        return true;
    }
}
