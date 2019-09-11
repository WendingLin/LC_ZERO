class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J.length()==0 || S.length()==0) return 0;
        boolean[] exist = new boolean[256];
        for(char c:J.toCharArray()) exist[c] = true;
        int count = 0;
        for(char c:S.toCharArray()) if(exist[c]) count++;
        return count;
    }
}
