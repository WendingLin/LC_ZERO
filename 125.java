class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0) return true;
        int left = 0, right = s.length()-1;
        s = s.toLowerCase();
        while(left<=right){
            if(Character.isLetterOrDigit(s.charAt(left))==false){
                left++;
            }else if(Character.isLetterOrDigit(s.charAt(right))==false){
                right--;
            }else{
                char l = s.charAt(left++);
                char r = s.charAt(right--);
                if(l==r) continue;
                else return false;
            }
        }
        
        return true;
    }
}
