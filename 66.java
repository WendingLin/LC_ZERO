class Solution {
  public int[] plusOne(int[] digits) {
    int n = digits.length;
    int ci = 0;

    for (int i = n - 1; i >= 0; i--) {
      int num = digits[i] + ci;
      if (i == n - 1)
        num++;

      if (num > 9) {
        ci = 1;
        num = num % 10;
      } else
        ci = 0;
      digits[i] = num;
    }
    if (ci == 1) {
      int res[] = new int[n + 1];
      res[0] = 1;
      for (int i = 0; i < n; i++) {
        res[i + 1] = digits[i];
      }
      return res;
    }
    return digits;
  }
}
