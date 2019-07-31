class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right <= nums.length){
            if(sum >= s){
                res = Math.min(res, right-left);
                sum -= nums[left++];
            }else{
                if(right==nums.length) break;
                sum += nums[right++];
            }
        }
        if(res==Integer.MAX_VALUE) return 0;
        return res;
    }
}
