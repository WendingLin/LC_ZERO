class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>();
        for(String word:wordDict){
            set.add(word);
        }
        for(int i = 1; i<=s.length(); i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))) dp[i] = true;
            }
        }
        return dp[len];
    }
}
