class Solution {
    public int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        int res = 0;
        for(int i = 0; i<len; i++){
            for(int j = i; j>=0; j--){
                dp[j][i] = (s.charAt(j)==s.charAt(i)) && (i-j<2 || dp[j+1][i-1]);
                if(dp[j][i]) res++;
            }
        }
        
        return res;
    }
}
