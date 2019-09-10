class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[256];
        for(char c:s1.toCharArray()){
            count[c]++;
        }
        int remain = s1.length();
        int left = 0;
        int right = 0;
        while(right<s2.length()){
            char c = s2.charAt(right++);
            if(count[c]-->0){
                remain--;
            }
            if(remain==0) return true;
            if(right-left==s1.length()){
                char cl = s2.charAt(left++);
                if(count[cl]++>=0){
                    remain++;
                }
            }
        }
        return false;
    }
}
