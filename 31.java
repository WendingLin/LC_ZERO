class Solution {

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    private void rangeswap(int[] nums, int left, int right){
        for(int i = 0; i<(right-left+1)/2; i++){
            swap(nums, left+i, right-i);
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return;
        
        int pos = nums.length-1;
        for(int i = nums.length-1; i>0; i--){
            if(nums[i-1]>=nums[i]){
                continue;
            }
            else{
                pos = i-1;
                int find = nums.length-1;
                while(find>pos && nums[find]<=nums[pos]){
                    find--;
                    continue;
                }
                swap(nums, pos, find);
                rangeswap(nums, pos+1, nums.length-1);
                return;
            }
        }
        rangeswap(nums, 0, nums.length-1);  
    }
}
