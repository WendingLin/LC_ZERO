class Solution {
    private void backTracking(List<List<Integer>> res, List<Integer> temp, int count, int k, int n, int start){
        if(count+(k-temp.size())*9<n){
            return;
        }else if(count>n){
            return;
        }
        else if(temp.size()==k){
            if(count==n){
                res.add(new ArrayList<Integer>(temp));
            }else{
                return;
            }
        }else{
            for(int i = start; i<10; i++){
                temp.add(i);
                backTracking(res, temp, count+i, k, n, i+1);
                temp.remove(temp.size()-1);
            }  
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTracking(res, temp, 0, k, n, 1);
        
        return res;
    }
}
