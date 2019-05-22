class Solution {
  public int maxProfit(int[] prices) {
    int len = prices.length;
    if (len == 0) {
      return 0;
    }
    int global[][] = new int[len][3];
    int local[][] = new int[len][3];
    for (int i = 1; i < len; i++) {
      int diff = prices[i] - prices[i - 1];
      for (int j = 1; j < 3; j++) {
        local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + diff;
        global[i][j] = Math.max(local[i][j], global[i - 1][j]);
      }
    }
    return global[len - 1][2];
  }
}
