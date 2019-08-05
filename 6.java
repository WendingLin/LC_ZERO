class Solution {
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0 || numRows==1) return s;
        char[] res = new char[s.length()];
        int cube = 2*numRows-2;
        int looptime = s.length()/cube;
        int count = 0;
        for(int i = 0; i<numRows; i++){
            for(int j = 0; j<looptime; j++){
                res[count++] = s.charAt(j*cube+i);
                if(i>0 && i<numRows-1) res[count++] = s.charAt(j*cube+cube-i);
            }
            if(looptime*cube+i<s.length()) res[count++] = s.charAt(looptime*cube+i);
            if(i>0 && i<numRows-1 && looptime*cube+cube-i<s.length()) res[count++] = s.charAt(looptime*cube+cube-i);
        }
        return String.valueOf(res);
    }
}
