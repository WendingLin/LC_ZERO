class Solution {
  public String reverseVowels(String s) {
    HashSet vowel = new HashSet();
    vowel.add('a');
    vowel.add('e');
    vowel.add('i');
    vowel.add('o');
    vowel.add('u');
    vowel.add('A');
    vowel.add('E');
    vowel.add('I');
    vowel.add('O');
    vowel.add('U');
    int left = 0;
    int right = s.length() - 1;
    char a[] = s.toCharArray();
    while (left < right) {
      while (left < right && vowel.contains(a[left]) == false)
        left++;
      while (left < right && vowel.contains(a[right]) == false)
        right--;
      if (left < right) {
        char temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        left++;
        right--;
      }
    }
    return new String(a);
  }
}
