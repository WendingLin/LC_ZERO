class Solution {
    public String toHex(int num) {
      if (num == 0) return "0";
      StringBuilder res = new StringBuilder();
      
      while (num != 0) {
          int digit =num & 0xf;
          res.append(digit < 10 ? (char)(digit + '0') : (char)(digit - 10 + 'a'));
          num >>>= 4;
      }
      
    return res.reverse().toString();
    }
}
