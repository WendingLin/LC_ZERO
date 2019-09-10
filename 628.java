class Solution {
    public int maximumProduct(int[] nums) {
        int[] pos = {0,0,0};
        int[] neg = {0,0};
        int countp = 0;
        int countn = 0;
        int res = 1;
        for(int num:nums){
            res*=num;
            if(num>0){
                countp++;
                if(num>pos[2]){
                    pos[0] = pos[1];
                    pos[1] = pos[2];
                    pos[2] = num;
                    
                }
                else if(num>pos[1]){
                    pos[0] = pos[1];
                    pos[1]= num;
                } 
                else if(num>pos[0]) pos[0] = num;
                else continue;
            }else if(num<0){
                countn++;
                if(num<neg[1]) {
                    neg[0] = neg[1];
                    neg[1]= num;
                }
                else if(num<neg[0]) neg[0] = num;
                else continue;
            }else{
                continue;
            }
        }
        if(nums.length<=3) return res;
        res = 0;
        if(countp>=3) res = Math.max(res, pos[2]*pos[1]*pos[0]);
        if(countn>=2) res = Math.max(res, neg[1]*neg[0]*pos[2]);
        return res;
    }
}
