class Solution {
    public int factorial(int number) {
        int res = 1;
        for(int i = 2; i<=number; i++)
            res *= i;
        return res;
    }

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        String res = "";
        for(int time = 0; time<n; time++){
            int partfac = factorial(n-time-1);
            int range = (k-1)/partfac;
            int count = 0;
            for(int i = 0; i<used.length; i++){
                if(count==range && used[i]==false) {
                    count = i;
                    break;
                }
                if(used[i]==false) count++;
            }
            used[count] = true;
            k = k-range*partfac;
            res += String.valueOf(count+1);
        }
        return res;
    }
}
