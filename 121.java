class Solution {
  public int maxProfit(int[] prices) {
    int buy = Integer.MAX_VALUE;
    int res = 0;
    for (int price : prices) {
      buy = Math.min(buy, price);
      res = Math.max(res, price - buy);
    }
    return res;
  }
}
