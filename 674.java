class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int res = 1;
        int last = nums[0];
        int curr = 1;
        for(int num:nums){
            if(num>last){
                curr++;
                res = Math.max(res, curr);
            }else{
                curr = 1;
            }
            last = num;
        }
        return res;
    }
}
