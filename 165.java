class Solution {
  public int compareVersion(String version1, String version2) {
    String v1str[] = version1.split("\\.");
    String v2str[] = version2.split("\\.");
    int len1 = v1str.length;
    int len2 = v2str.length;
    for (int i = 0; i < Math.max(len1, len2); i++) {
      int val1 = (i >= len1) ? 0 : Integer.valueOf(v1str[i]);
      int val2 = (i >= len2) ? 0 : Integer.valueOf(v2str[i]);
      if (val1 > val2)
        return 1;
      else if (val1 < val2)
        return -1;
      else
        continue;
    }
    return 0;
  }
}
