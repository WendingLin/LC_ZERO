class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    int pos_1 = -1;
    int pos_2 = -1;
    int min_dis = words.length;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        pos_1 = i;
        if (pos_2 != -1)
          min_dis = Math.min(min_dis, Math.abs(pos_1 - pos_2));
      } else if (words[i].equals(word2)) {
        pos_2 = i;
        if (pos_1 != -1)
          min_dis = Math.min(min_dis, Math.abs(pos_1 - pos_2));
      } else
        continue;
    }
    return min_dis;
  }
}
