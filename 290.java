class Solution {
  public boolean wordPattern(String pattern, String str) {
    String word[] = str.split(" ");
    if (word.length != pattern.length())
      return false;
    HashMap<Character, String> dict = new HashMap<Character, String>();
    for (int i = 0; i < word.length; i++) {
      if (dict.containsKey(pattern.charAt(i)) == true) {
        if (dict.get(pattern.charAt(i)).equals(word[i]))
          continue;
        else
          return false;
      } else {
        if (dict.containsValue(word[i]))
          return false;
        dict.put(pattern.charAt(i), word[i]);
      }
    }
    return true;
  }
}
