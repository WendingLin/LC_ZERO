class Solution {
    public boolean canPartition(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return false;
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int num:nums){
            if(num>sum/2) return false;
            for(int i = sum; i>=0; i--){
                if(dp[i]) dp[i+num] = true;
            }
            if(dp[sum/2]) return true;
        }
        return false;
        
    }
}
