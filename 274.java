class Solution {
  public int hIndex(int[] citations) {
    if (citations.length == 0)
      return 0;
    int len = citations.length;
    int[] stats = new int[len + 1];
    for (int citation : citations) {
      stats[citation > len ? len : citation]++;
    }

    int sum = 0;
    for (int i = len; i >= 0; i--) {
      sum += stats[i];
      if (sum >= i)
        return i;
    }
    return 0;
  }
}
