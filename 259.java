class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if(nums==null || nums.length<3) return 0;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            int starget = target-nums[i];
            int left = i+1;
            int right = nums.length-1; 
            while(left<right){
                int sum  = nums[left] + nums[right];
                if(sum>=starget) right--;
                else{
                    count += right-left;
                    left++;
                     /*while(left<right && nums[left]==nums[left-1]){
                         left++;
                     }*/
                }
            }
        }
        return count;        
    }
}
