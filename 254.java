class Solution {
    private void backTracking(List<List<Integer>> res, List<Integer> temp, int number, int start){
        if(number<=1){
            if(temp.size()>1) res.add(new ArrayList<Integer>(temp));
            return;
        }else{
            for(int i = start; i<=number; i++){
                if(number%i==0){
                    temp.add(i);
                    backTracking(res, temp, number/i, i);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        backTracking(res, temp, n, 2);
        
        return res;
    }
}
