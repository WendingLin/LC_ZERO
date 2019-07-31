class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] up = new int[nums.length];
        int[] low = new int[nums.length];
        int res = nums[0];
        up[0] = low[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            up[i] = Math.max(nums[i], Math.max(up[i-1]*nums[i], low[i-1]*nums[i]));
            low[i] = Math.min(nums[i], Math.min(up[i-1]*nums[i], low[i-1]*nums[i]));
            res = Math.max(res, up[i]);
        }
        return res;
    }
}
