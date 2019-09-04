class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[256];
        List<Integer> res = new ArrayList<>();
        for(char c:p.toCharArray()) map[c]++;
        int left = 0;
        int right = 0;
        int remain = p.length();
        while(right<s.length()){
            if(map[s.charAt(right++)]-->=1){
                remain--;
            }
            
            
            if(remain==0) res.add(left);
            
            if(right-left==p.length() && map[s.charAt(left++)]++>=0){
                remain++;
            }
        }
        
        return res;
    }
}
