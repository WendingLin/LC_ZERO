class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks==null||tasks.length==0) return 0;
        int[] count  = new int[26];
        for(char c : tasks){
            count[c-'A']++;
        }
        Arrays.sort(count);
        int i = 24;
        while(count[i]==count[i+1]) i--;
        int same = 25-i;
        
        return Math.max(tasks.length, (n+1)*(count[25]-1)+same);
    }
}
