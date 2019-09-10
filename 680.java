class Solution {
    private boolean helper(String s, boolean use){
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            char cl = s.charAt(left);
            char cr = s.charAt(right);
            if(cl!=cr){
                if(use) return false;
                else{
                    use = true;
                    if((cl==s.charAt(right-1)) && helper(s.substring(left, right), true)) return true;
                    if((cr==s.charAt(left+1)) && helper(s.substring(left+1, right+1), true)) return true;
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;        
    }
    public boolean validPalindrome(String s) {
        return helper(s, false);
    }
}
