class Solution {
    private String buildInterval(int num1, int num2){
        if(num2-num1==2) return String.valueOf(num1+1);
        return String.valueOf(num1+1)+"->"+String.valueOf(num2-1);
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if(nums==null || nums.length==0){
            res.add(buildInterval(lower-1, upper+1));
            return res;
        }
        if(nums[0]>lower) res.add(buildInterval(lower-1, nums[0]));
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1]==nums[i]) continue;
            if(nums[i-1]+1!=nums[i]) res.add(buildInterval(nums[i-1], nums[i]));   
        }
        if(nums[nums.length-1]<upper) res.add(buildInterval(nums[nums.length-1], upper+1));
        return res;
    }
}
