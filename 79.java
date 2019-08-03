class Solution {
    private int to1DPos(int x, int y, int n){
        return x*n+y;
    }
    private boolean DFS(char[][] board, boolean[] used, String word, int pos, int i, int j, int n){
        if(i<0 || i>=board.length || j<0 || j>=n || used[to1DPos(i, j, n)]) return false;
        char c = board[i][j];
        if(c==word.charAt(pos)){
            if(++pos==word.length()) return true;
            used[to1DPos(i, j, n)] = true;
            boolean up = DFS(board, used, word, pos, i-1, j, n);
            boolean down = DFS(board, used, word, pos, i+1, j, n);
            boolean left = DFS(board, used, word, pos, i, j-1, n);
            boolean right = DFS(board, used, word, pos, i, j+1, n);
            if(up||down||left||right) return true;
            used[to1DPos(i, j, n)] = false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[] used = new boolean[m*n];
        int pos = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(DFS(board, used, word, 0, i, j, n)) return true;
            }
        }
        return false;
        
    }
}
