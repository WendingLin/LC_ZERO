class Solution {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0)
      return "";
    int len = nums.length;
    String[] strs = new String[len];

    for (int i = 0; i < len; i++) {
      strs[i] = String.valueOf(nums[i]);
    }

    Arrays.sort(strs, new Comparator<String>() {
      public int compare(String s1, String s2) {
        String s1s2 = s1 + s2;
        String s2s1 = s2 + s1;
        return s1s2.compareTo(s2s1);
      }
    });

    String res = new String();

    for (String str : strs) {
      res = str + res;
    }
    for (int i = 0; i < res.length(); i++) {
      if (res.charAt(i) != '0')
        return res.substring(i, res.length());
    }

    return "0";
  }
}
