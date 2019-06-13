class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0)
      return new ArrayList<List<String>>();
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
      char[] ca = str.toCharArray();
      Arrays.sort(ca);
      String temp = String.valueOf(ca);
      if (map.containsKey(temp) == true)
        map.get(temp).add(str);
      else {
        List<String> strlist = new ArrayList<String>();
        strlist.add(str);
        map.put(temp, strlist);
      }
    }
    return new ArrayList<List<String>>(map.values());
  }
}
