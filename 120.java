class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int levels = triangle.size();
        int[] dp = new int[levels];
        for(int i = 0; i<levels; i++){
            dp[i] = triangle.get(levels-1).get(i);
        }
        for(int level = levels-2; level>=0 ;level--){
            for(int i = 0; i<level+1; i++){
                dp[i] = triangle.get(level).get(i) + Math.min(dp[i], dp[i+1]);
            }
        }
        return dp[0];
    }
}
