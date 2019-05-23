class Solution {
  public int maximumGap(int[] nums) {
    int n = nums.length;
    if (n < 2)
      return 0;

    int min = Integer.MAX_VALUE;
    for (int cur : nums)
      min = Math.min(cur, min);
    int max = Integer.MIN_VALUE;
    for (int cur : nums)
      max = Math.max(cur, max);

    int avg_gap = (max - min) / (n - 1);
    if (avg_gap == 0)
      return max - min;
    int num_buc = (max - min) / avg_gap + 1;

    int mina[] = new int[num_buc];
    int maxa[] = new int[num_buc];

    for (int num : nums) {
      int pos = (num - min) / avg_gap;
      if (mina[pos] == 0 || num < mina[pos])
        mina[pos] = num;
      if (num > maxa[pos])
        maxa[pos] = num;
    }
    int res = 0;
    int last_max = maxa[0];
    for (int i = 0; i < num_buc - 1; i++) {
      if (mina[i + 1] != 0) {
        res = Math.max(res, mina[i + 1] - last_max);
        last_max = maxa[i + 1];
      }
    }
    return res;
  }
}
