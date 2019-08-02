class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update:updates){
            int val = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += val;
            if(end+1<length) res[end+1] -=val;
        }
        int sum = 0;
        for(int i = 0; i<length; i++){
            res[i] = sum + res[i];
            sum = res[i];
        }
        return res;
    }
}
