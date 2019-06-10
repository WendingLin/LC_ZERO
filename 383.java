class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> count = new HashMap<Character, Integer>();
    for (int i = 0; i < magazine.length(); i++) {
      char c = magazine.charAt(i);
      if (count.containsKey(c))
        count.put(c, count.get(c) + 1);
      else
        count.put(c, 1);
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      char c = ransomNote.charAt(i);
      if (count.containsKey(c) == false || count.get(c) == 0)
        return false;
      count.put(c, count.get(c) - 1);
    }
    return true;
  }
}
