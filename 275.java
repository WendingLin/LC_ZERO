class Solution {
  public int hIndex(int[] citations) {
    int len = citations.length;
    if (len == 0)
      return 0;

    int left = 0;
    int right = len - 1;

    int mid = (left + right) / 2;
    while (left <= right) {
      mid = (left + right) / 2;
      if (citations[mid] < len - mid)
        left = mid + 1;
      else if (citations[mid] > len - mid)
        right = mid - 1;
      else
        return len - mid;
    }

    return len - left;
  }
}
