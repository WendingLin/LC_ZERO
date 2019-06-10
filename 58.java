class Solution {
  public int lengthOfLastWord(String s) {
    boolean flag = false;
    int count = 0;
    int i = s.length() - 1;
    while (i >= 0 && (s.charAt(i) != ' ' && flag || !flag)) {
      if (s.charAt(i) != ' ') {
        flag = true;
        count++;
      }

      i--;
    }
    return count;
  }
}
