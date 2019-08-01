class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int left = 0;
        int right = 0;
        for(int num:nums){
            if(num>dp[right]){
                dp[++right] = num;
            }else{
                int lpos = left;
                int rpos = right;
                while(lpos<=rpos){
                    int mid = lpos + (rpos-lpos)/2;
                    if(lpos==rpos || dp[mid]==num){
                        dp[mid] = num;
                        break;
                    }
                    else if(dp[mid]<num) lpos = mid +1;
                    else rpos = mid;
                }
            }
        }
        return right+1;
    }
}
