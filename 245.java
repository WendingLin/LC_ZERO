class Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    boolean equ = word1.equals(word2);
    int pos1 = -1;
    int pos2 = -1;
    int min_dis = words.length;
    boolean flag = false;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1) &&
          ((equ == false) || (equ == true && flag == false))) {
        pos1 = i;
        flag = true;
      } else if (words[i].equals(word2) &&
                 ((equ == false) || (equ == true && flag == true))) {
        pos2 = i;
        flag = false;
      } else {
        continue;
      }

      if (pos1 != -1 && pos2 != -1) {
        min_dis = Math.min(min_dis, Math.abs(pos1 - pos2));
      }
    }
    return min_dis;
  }
}
