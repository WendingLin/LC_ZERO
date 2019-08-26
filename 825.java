class Solution {
    public int numFriendRequests(int[] ages) {
        if(ages==null || ages.length==0) return 0;
        int res = 0;
        
        int[] num = new int[121];
        int[] sum = new int[121];
        
        for(int age:ages) num[age]++;
        
        for(int i = 1; i<=120; i++){
            sum[i] = num[i] + sum[i-1];
        }
        for(int i = 15; i<=120; i++){
            int count = sum[i]-sum[i/2+7];
            res += (count-1)*num[i];
        }
        return res;
    }
}
