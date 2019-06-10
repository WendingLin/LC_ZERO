class Solution {
  private int getMinLength(String[] strs) {
    int min_len = Integer.MAX_VALUE;
    for (String str : strs)
      min_len = Math.min(min_len, str.length());
    return min_len;
  }

  private boolean allContainsSamePrefix(String[] strs, int start, int end) {
    int len = strs.length;
    for (int i = start; i <= end; i++) {
      for (int j = 0; j < len - 1; j++) {
        if (strs[j].charAt(i) != strs[j + 1].charAt(i))
          return false;
      }
    }
    return true;
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0)
      return "";
    int min_len = getMinLength(strs);
    int left = 0;
    int right = min_len - 1;
    String res = "";
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (allContainsSamePrefix(strs, left, mid)) {
        res += strs[0].substring(left, mid + 1);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return res;
  }
}
