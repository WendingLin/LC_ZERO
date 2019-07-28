class Solution {
    private void backTracking(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int start, int sum){
        if(sum>target){
            return;
        }else if(sum==target){
            res.add(new ArrayList<Integer> (temp));
            return;
        }else{
            for(int i = start; i<candidates.length; i++){
                if(i>start && candidates[i]==candidates[i-1]) continue;
                temp.add(candidates[i]);
                backTracking(candidates, res, temp, target, i+1, sum + candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        backTracking(candidates, res, temp, target, 0, 0);
        
        return res;
    }
}
