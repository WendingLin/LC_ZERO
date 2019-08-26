class Solution {
    public int countBattleships(char[][] board) {
        if(board==null || board.length==0 ||board[0].length==0) return 0;
        int count = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                char c = board[i][j];
                if(c=='.') continue;
                else{
                    if(i>0 && board[i-1][j]=='X') continue;
                    if(j>0 && board[i][j-1]=='X') continue;
                    count++;
                }
            }
        }
        return count;
    }
}
