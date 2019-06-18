class Solution {
  public boolean isStrobogrammatic(String num) {
    // 6+9 8+8 2+5 1+1
    for (int i = 0; i < num.length(); i++) {
      char left = num.charAt(i);
      char right = num.charAt(num.length() - 1 - i);
      if (left == right) {
        if (left != '8' && left != '1' && left != '0')
          return false;
        else
          continue;

      } else {
        if (left == '6' && right == '9')
          continue;
        else if (left == '9' && right == '6')
          continue;
        else
          return false;
      }
    }
    return true;
  }
}
