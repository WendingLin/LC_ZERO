class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        int m1 = 1;
        int m2 = 1;
        for(int i = 1; i<s.length(); i++){
            int temp = m1;
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2') m1 = m2;
                else m1 = 0;
            }
            else if(s.charAt(i)<'7' && s.charAt(i-1)=='2' || s.charAt(i-1)=='1') m1 += m2;
            m2 = temp;
        }
        return m1;
    }
}
