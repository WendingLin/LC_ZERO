class Solution {
    private void backTracking(List<List<Integer>> res, List<Integer> temp, int n, int k, int start){
        if(temp.size()==k){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        if(temp.size() == 1 && temp.get(0) + k - 1>n)
            return;
        
        for(int i = start; i<=n; i++){
            temp.add(i);
            backTracking(res, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backTracking(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
}
