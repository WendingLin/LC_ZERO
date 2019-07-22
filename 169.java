class Solution {
    public int majorityElement(int[] nums) {
        int max = 1;
        int res = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.get(num)==null){
                map.put(num, 1);
            }else{
                int count = map.get(num);
                if(count+1>max){
                    max = count + 1;
                    res = num;
                }
                map.put(num, count+1);
            }
        }
        return res;
    }
}
