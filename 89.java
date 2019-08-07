class Solution {
    private int mypow(int n){
        int res = 1;
        for(int i = 0; i<n; i++) res*=2;
        return res;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 0; i<n; i++){
            int start = mypow(i);
            for(int j = 0; j<start; j++){
                int val = start + res.get(start-j-1);
                res.add(val);
            }
        }
        return res;
    }
}
