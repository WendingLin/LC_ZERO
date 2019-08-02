class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int leftvertical = 0, rightvertical = n-1;
        int uphori = 0, downhori = n-1;
        int count = 1;
        while(leftvertical<=rightvertical && uphori<=downhori){
            for(int i = leftvertical; i<=rightvertical; i++){
                res[uphori][i] = count++;
            }
            
            for(int i = uphori+1; i<downhori; i++){
                res[i][rightvertical] = count++;
            }
            
            if(uphori!=downhori){
                for(int i = rightvertical; i>=leftvertical; i--){
                    res[downhori][i] = count++;
                }
            }
            if(leftvertical!=rightvertical){
                for(int i = downhori-1; i>uphori; i--){
                    res[i][leftvertical] = count++;
                }
            }
            leftvertical++;
            rightvertical--;
            uphori++;
            downhori--;            
        }
        return res;
    }
}
