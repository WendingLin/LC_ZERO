class Solution {
    public boolean rotateString(String A, String B) {
        int lena = A.length();
        int lenb = B.length();
        
        if(lena!=lenb) return false;
        if(lena == 0) return true;
        for(int i = 0; i<lena; i++){
            String temp = A.substring(lena-i)+A.substring(0, lena-i);
            if(temp.equals(B)) return true;
        }
        return false;
    }
}
