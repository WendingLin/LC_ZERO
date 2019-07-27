class Solution {
    private void backTracking(int[] nums, List<List<Integer>> res, List<Integer> temp, int start){
        res.add(new ArrayList<Integer>(temp));
        for(int i = start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backTracking(nums, res, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null) return null;
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backTracking(nums, res, new ArrayList<Integer>(), 0);
        
        return res;
    }
}
