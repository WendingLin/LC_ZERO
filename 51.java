class Solution {
    private int[] q;
    List<List<String>> res = new ArrayList<>();
        
    private void addResult(int n){
        List<String> respart = new ArrayList<>();
        for(int i = 0; i<q.length; i++){
            char[] temp = new char[n];
            for(int j = 0; j<n; j++){
                temp[j] = j==q[i]?'Q':'.';
            }
            String cat = String.valueOf(temp);
            respart.add(cat);
        }
        res.add(respart);
    }
    
    private boolean check(int i, int j){
        for(int m = 0; m < i; m++){
            if(q[m] == j || (i-m)==Math.abs(j-q[m]))
                return false;
        }
        return true;
    }
    
    private void place(int i, int n){
        if(i==n){
            addResult(n);
        }
        for(int j = 0; j<n; j++){
            if(check(i, j)==true){
                q[i] = j;
                place(i+1, n);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        q = new int[n];
        place(0, n);
        return res;
    }
}
