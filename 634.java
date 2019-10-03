class Solution {
    public int findDerangement(int n) {
        if(n==1) return 0;
        if(n==2) return 1;
        long m1 = 1;
        long m2 = 0;
        
        for(int i = 3; i<=n; i++){
            long temp = (i-1)*(m1+m2)%1000000007;
            m2 = m1;
            m1 = temp;
        }
        
        int res = (int)m1;
        return res;
    }
}
