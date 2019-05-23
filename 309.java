class Solution {
  public int maxProfit(int[] prices) {
    int len = prices.length;
    if (len == 0)
      return 0;
    int hold[] = new int[len + 1];
    int sell[] = new int[len + 1];
    int rest[] = new int[len + 1];
    hold[0] = -Integer.MAX_VALUE;
    for (int i = 1; i < len + 1; i++) {
      hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i - 1]);
      sell[i] = hold[i - 1] + prices[i - 1];
      rest[i] = Math.max(rest[i - 1], sell[i - 1]);
    }

    return Math.max(sell[len], rest[len]);
  }
}
