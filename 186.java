class Solution {
  private void reversePart(char[] str, int start, int end) {
    for (int i = 0; i < (end - start) / 2; i++) {
      char temp = str[start + i];
      str[start + i] = str[end - 1 - i];
      str[end - 1 - i] = temp;
    }
  }

  public void reverseWords(char[] str) {
    reversePart(str, 0, str.length);
    boolean inword = false;
    int start = 0;
    for (int i = 0; i < str.length; i++) {
      if (str[i] == ' ') {
        reversePart(str, start, i);
        start = i + 1;
      }
    }
    reversePart(str, start, str.length);
  }
}
