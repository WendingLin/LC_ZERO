class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        int res = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        int sum = 0;
        count.put(0, 1);
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(count.containsKey(sum-k)) res+=count.get(sum-k);
            if(count.containsKey(sum)){
                count.put(sum, count.get(sum) + 1);
            }else{
                count.put(sum, 1);
            }
        }
        return res;
    }
}
