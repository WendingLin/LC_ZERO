class Solution {
    private int add (int r, int c, int R, int C, int count, int[][] res) {
        if (r >= R || r < 0 || c >= C || c < 0) return  count;
        res[count] = new int[]{r, c};
        return count+1;
    }
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int count = 0;
        int step = 1;
        int[][] res = new int[R*C][2];
        while(count<R*C){
            for(int i = 0; i<step; i++) count = add(r0, c0++, R, C, count, res);
            for(int i = 0; i<step; i++) count = add(r0++, c0, R, C, count, res);
            step++;
            for(int i = 0; i<step; i++) count = add(r0, c0--, R, C, count, res);
            for(int i = 0; i<step; i++) count = add(r0--, c0, R, C, count, res);
            step++;
        }
        return res;
    }
}
