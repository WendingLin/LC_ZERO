class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length())
      return false;
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    for (int i = 0; i < s.length(); i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      if (map.containsKey(sc)) {
        if (map.get(sc) != tc)
          return false;
      } else {
        if (map.containsValue(tc) == true)
          return false;
        map.put(sc, tc);
      }
    }
    return true;
  }
}
