class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null) return null;
        int[] res = new int[T.length];
        int[] dp = new int[71];
        for(int i = T.length-1; i>=0; i--){
            int index = T[i]-30;
            int min = -1;
            for(int j = index+1; j<71; j++){
                if(dp[j]>i){
                    if(min==-1) min = dp[j];
                    else min = Math.min(min, dp[j]);
                }
            }
            res[i] = min==-1?0:min-i;
            dp[index] = i;
        }
        return res;
    }
}
