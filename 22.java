class Solution {
    private void backTracking(List<String> res, String temp, int n, int left){
        if(n==0 && left==0){
            res.add(temp);
            return;
        }
        if(n>0) backTracking(res, temp + String.valueOf('('), n-1, left+1);
        if(left>0) backTracking(res, temp+String.valueOf(')'), n, left-1);

    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(res, "", n, 0);
        return res;
    }
}
