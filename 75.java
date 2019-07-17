class Solution {
    public void sortColors(int[] nums) {
        int pos0 = -1;
        int pos2 = nums.length;
        for(int num:nums){
            if(num==0)
                pos0++;
            if(num==2)
                pos2--;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(i<=pos0)
                nums[i] = 0;
            else if(i>=pos2)
                nums[i] = 2;
            else
                nums[i] = 1;
        }
        return;
    }
}
