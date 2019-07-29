class Solution {
    private void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtracking(res, temp, nums);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
         if(nums==null) return null;
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        backtracking(res, new ArrayList<Integer>(), nums);

        return res;        
    }
}
