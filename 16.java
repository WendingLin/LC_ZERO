class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = -1;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1; 
            while(left<right){
                int sum  = nums[left] + nums[right]+nums[i];
                int diff = Math.abs(sum-target);
                if(diff<min){
                    min = diff;
                    res = sum;
                }
                if(sum>target){
                    right--;
                    while(right>left && nums[right]==nums[right+1]) right--;
                }
                else if(sum<target){ 
                    left++;
                    while(left+1<right && nums[left]==nums[left-1]) left++;
                }
                else return target;
            }
        }
        return res;        
    }
}
