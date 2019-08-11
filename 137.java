class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for(int num:nums){
            int sum = num & one;
            one ^= num;
            two ^= sum;
            int three = one & two;
            one ^= three;
            two ^= three;
        }
        return one;
    }
}
