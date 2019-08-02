class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A==null || B==null || A[0].length==0 || B[0].length==0) return null;
        int am = A.length, bm = B.length;
        int an = A[0].length, bn = B[0].length;
        Set<Integer> azerorow = new HashSet<>();
        Set<Integer> bzerocolumn = new HashSet<>();
        for(int i = 0; i<am; i++){
            boolean flag= true;
            for(int j = 0; j<an; j++){
                if(A[i][j]!=0){
                    flag = false;
                    break;
                }
            }
            if(flag==true) azerorow.add(i);
        }
        
        for(int i = 0; i<bn; i++){
            boolean flag= true;
            for(int j = 0; j<bm; j++){
                if(B[j][i]!=0){
                    flag = false;
                    break;
                }
            }
            if(flag==true) bzerocolumn.add(i);
        }
        
        int[][] res = new int[am][bn];
        
        for(int ar = 0; ar<am; ar++){
            for(int bc = 0; bc<bn; bc++){
                if(azerorow.contains(ar)||bzerocolumn.contains(bc)){
                    res[ar][bc] = 0;
                }else{
                    for(int i = 0; i<an; i++){
                        res[ar][bc] += A[ar][i]*B[i][bc];
                    }
                }
            }
        }
        return res;   
    }
}
