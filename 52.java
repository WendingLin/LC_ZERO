class Solution {
    int size;
    int count = 0;
    int[] q;
    
    private boolean check(int i, int j){
        for(int m = 0; m<i; m++){
            if(q[m]==j || (i-m==Math.abs(q[m]-j)))
                return false;
        }
        return true;
    }
    
    private void place(int i){
        if(i == size){
            count++;
        }
        for(int j = 0; j<size; j++){
            if(check(i, j)==true){
                q[i] = j;
                place(i+1);
            }
        }
    }
    
    public int totalNQueens(int n) {
        if(n<1) return 0;
        size = n;
        q = new int[n];
        place(0);
        return count;
    }
}
