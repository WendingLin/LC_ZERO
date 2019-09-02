class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        String res = "";
        int len1 = num1.length(), len2 = num2.length();
        for(int i = 0; i<len1 || i<len2; i++){
            int val1 = i<len1?num1.charAt(len1-1-i) - '0':0;
            int val2 = i<len2?num2.charAt(len2-1-i) - '0':0;
            int val = val1 + val2 + carry;
            res = String.valueOf(val%10) + res;
            carry = val/10;
        }
        if(carry!=0) res = String.valueOf(carry) + res;
        return res;
    }
}
