class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        
        int[] lastpos = new int[256];
        Arrays.fill(lastpos, -1);
        int res = 0;
        int left = -1;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(lastpos[c]>=left){
                left = lastpos[c];
            }
            res = Math.max(res, i-left);
            lastpos[c] = i;
        }
        return res;
    }
}1
