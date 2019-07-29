class Solution {
    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] used){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtracking(nums, res, temp, used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null) return null;
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        backtracking(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);

        return res;
    }
}
