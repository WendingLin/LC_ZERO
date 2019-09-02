class Solution {
    int[] nums;
    Random rnd;
    public Solution(int[] nums) {
        this.nums = nums;
        rnd = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=target) continue;
            count++;
            if(count==1 || rnd.nextInt(count)==0) res = i;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
