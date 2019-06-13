class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    if (strings == null || strings.length == 0)
      return new ArrayList<List<String>>();
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strings) {
      String temp = "";
      for (int i = 1; i < str.length(); i++) {
        char nc = (char)('a' + (str.charAt(i) - str.charAt(0) + 26) % 26);
        temp += nc;
      }
      if (map.containsKey(temp)) {
        map.get(temp).add(str);
      } else {
        List<String> newstr = new ArrayList<String>();
        newstr.add(str);
        map.put(temp, newstr);
      }
    }

    return new ArrayList<List<String>>(map.values());
  }
}
