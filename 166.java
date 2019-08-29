class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        String sig = numerator<0^denominator<0==true?"-":"";
        long nume = Math.abs((long)numerator);
        long deno = Math.abs((long)denominator);
        if(nume%deno == 0 ) return sig + String.valueOf(nume/deno);
        String frac = "";
        long lonu = (nume%deno);
        HashMap<Long, Integer> map = new HashMap<>();
        int pos = 0;
        while(map.containsKey(lonu)==false){
            map.put(lonu, pos);
            long res = lonu*10/deno;
            frac += String.valueOf(res);
            long rem = lonu*10%deno;
            if(rem==0) return sig+String.valueOf(nume/deno) + "." + frac;
            lonu = rem;
            pos++;
        }
        return sig + String.valueOf(nume/deno) + "." +frac.substring(0, map.get(lonu))+"("+frac.substring(map.get(lonu))+")";
    }
}
