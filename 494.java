class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int total = 0;
        for(int num:nums){
            total += num;
        }
        
        int news = total-S;
        if(news<0 || news%2!=0) return 0;
        
        int[] dp = new int[total+1];
        
        dp[0] = 1;
        for(int num:nums){
            if(num>news/2) continue;
            for(int i = total; i>=0; i--){
                if(dp[i]>0){
                    dp[i+num] += dp[i];
                }
            }
        }
        return dp[news/2];
    }
}
