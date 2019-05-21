class WordDistance {

  private HashMap<String, List<Integer>> wordpos_map;
  public WordDistance(String[] words) {
    wordpos_map = new HashMap<String, List<Integer>>();
    for (int i = 0; i < words.length; i++) {
      if (wordpos_map.containsKey(words[i])) {
        wordpos_map.get(words[i]).add(i);
      } else {
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(i);
        wordpos_map.put(words[i], temp);
      }
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> list1 = wordpos_map.get(word1);
    List<Integer> list2 = wordpos_map.get(word2);
    int i = 0;
    int j = 0;
    int min_dis = Integer.MAX_VALUE;
    while (i < list1.size() && j < list2.size()) {
      int w1_pos = list1.get(i);
      int w2_pos = list2.get(j);
      if (w1_pos < w2_pos) {
        min_dis = Math.min(min_dis, w2_pos - w1_pos);
        i++;
      } else {
        min_dis = Math.min(min_dis, w1_pos - w2_pos);
        j++;
      }
    }
    return min_dis;
  }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
