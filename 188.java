class Solution {
  public int maxProfit(int k, int[] prices) {
    int len = prices.length;
    if (len == 0)
      return 0;
    if (k >= len / 2) {
      int maxPro = 0;
      for (int i = 1; i < len; i++) {
        if (prices[i] > prices[i - 1])
          maxPro += prices[i] - prices[i - 1];
      }
      return maxPro;
    }

    int global[][] = new int[len][k + 1];
    int local[][] = new int[len][k + 1];

    for (int i = 1; i < len; i++) {
      int diff = prices[i] - prices[i - 1];
      for (int j = 1; j <= k; j++) {
        local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + diff;
        global[i][j] = Math.max(local[i][j], global[i - 1][j]);
      }
    }
    return global[len - 1][k];
  }
}
