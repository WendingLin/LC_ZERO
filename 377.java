class Solution {

    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length==0) return 0;
        Arrays.sort(nums);
        int[] res = new int[target+1];
        res[0] = 1;
        for(int i = nums[0]; i<=target; i++){
            for(int num:nums){
                if(i>=num) res[i] += res[i-num];
                else break;
            }
        }
        return res[target];
    }
}
