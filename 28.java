class Solution {
  public int strStr(String haystack, String needle) {
    int len_ori = haystack.length();
    int len_nee = needle.length();
    if (len_nee == 0)
      return 0;
    for (int i = 0; i <= len_ori - len_nee; i++) {
      if (haystack.substring(i, i + len_nee).equals(needle)) {
        return i;
      }
    }
    return -1;
  }
}
