class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            count += nums[i];
            if(count==k) res = i+1;
            if(map.containsKey(count)==false) map.put(count, i);
            
            int diff = count-k;
            if(map.containsKey(diff)==true) res = Math.max(res, i-map.get(diff));
        }
        return res;
    }
}
