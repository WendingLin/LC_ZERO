class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(left==right) return mid;
            if(mid+1<=nums.length-1 && nums[mid+1]>nums[mid]){
                left = mid + 1;
            }else if(mid-1>=0 && nums[mid-1]>nums[mid]){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
