class Solution {
    private void backTracking(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int start, int sum){
        if(sum>target){
            return;
        }else if(sum==target){
            res.add(new ArrayList<Integer> (temp));
            return;
        }else{
            for(int i = start; i<candidates.length; i++){
                temp.add(candidates[i]);
                backTracking(candidates, res, temp, target, i, sum + candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates==null && candidates.length==0){
            return res;
        }
        
        List<Integer> temp = new ArrayList<Integer>();
        backTracking(candidates, res, temp, target, 0, 0);
        
        return res;
    }
}
