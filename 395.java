class Solution {
    private int helper(String s, int k, int left, int right){
        if(left>=right) return 0;
        int[] count = new int[26];
        boolean hasres = false;
        for(int i = left; i<right; i++){
            char c = s.charAt(i);
            if(++count[c-'a']==k) hasres = true;
        }
        if(hasres == false) return 0;
        for(int i = 0; i < 26; i++){
            if(count[i] > 0 && count[i] < k){
                int pos = s.indexOf((char)(i + 'a'), left);
                return Math.max(helper(s, k, left, pos), helper(s, k, pos+1, right));
            }
        }
        return right-left;
    }
    
    public int longestSubstring(String s, int k) {
        if(s==null || s.length()==0) return 0;
        
        return helper(s, k, 0, s.length());
    }
}
