class Solution {
  public int divide(int dividend, int divisor) {
    if (dividend == 0)
      return 0;
    boolean sign = (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0)
                       ? true
                       : false;
    long dividendabs = Math.abs(Long.valueOf(dividend));
    long divisorabs = Math.abs(Long.valueOf(divisor));
    long result = 0;
    while (divisorabs <= dividendabs) {
      long multdivisor = divisorabs;
      long count = 1;
      while ((multdivisor << 1) <= dividendabs) {
        multdivisor <<= 1;
        count <<= 1;
      }
      dividendabs -= multdivisor;
      result += count;
    }
    result = sign ? result : -result;
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
      return Integer.MAX_VALUE;
    int res = Math.toIntExact(result);
    return res;
  }
}
