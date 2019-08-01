class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            if(left==right) return nums[left];
            int mid = left+(right-left)/2;
            if(nums[left]<nums[mid]){
                if(nums[left]<nums[right]) return nums[left];
                else left = mid;
            }else if(nums[right]>nums[mid]){
                right = mid;
            }else if(nums[left]==nums[mid]){
                left++;
            }else{
                right--;
            }
        }
        return nums[right];
    }
}
