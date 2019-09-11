class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] bucket = new int[10];
        
        for(int i = 0; i<digits.length; i++){
            int numa = digits[i]-'0';
            if(i>bucket[numa]) bucket[numa] = i;
        }
        
        boolean find = false;
        
        for(int i = 0; find==false && i<digits.length; i++){
            int numa = digits[i]-'0';
            for(int j = 9; j>numa; j--){
                if(bucket[j]>i){
                    digits[i] = (char)('0' + j);
                    digits[bucket[j]] = (char)('0' + numa);
                    find = true;
                    break;
                }
            }
        }
        if(find == false) return num;
        String res = new String(digits);
        return Integer.parseInt(res);
        
    }
}
