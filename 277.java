/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
  public int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      if (knows(candidate, i) == true)
        candidate = i;
    } // candidate not know (candidate, end]
    for (int i = 0; i < candidate; i++) {
      if (knows(candidate, i) == true)
        return -1;
    }
    for (int i = 0; i < n; i++) {
      if (i == candidate)
        continue;
      if (knows(i, candidate) == false)
        return -1;
    }
    return candidate;
  }
}
