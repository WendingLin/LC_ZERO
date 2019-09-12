class Solution {
   public boolean validTicTacToe(String[] board) {
        int cnt_X = 0, cnt_O = 0;
        for(String row : board){
            for(char c : row.toCharArray()){
                if(c == 'X') cnt_X++;
                if(c == 'O') cnt_O++;
            }
        }
        if(cnt_X < cnt_O || cnt_X > cnt_O + 1) return false;
        if(existTripple(board, 'X') && cnt_X - cnt_O != 1) return false;
        if(existTripple(board, 'O') && cnt_X != cnt_O) return false;
        return true;
    }
    private boolean existTripple(String[] board, char symbol){
        //diagonal
        if(board[1].charAt(1) == symbol){
            if(board[0].charAt(0) == symbol && board[2].charAt(2) == symbol) return true;
            if(board[0].charAt(2) == symbol && board[2].charAt(0) == symbol) return true;
        }
        //vertical
        for(int j = 0; j < 3; j++){
            if(board[0].charAt(j) == symbol){
                if(board[1].charAt(j) == symbol && board[2].charAt(j) == symbol) return true;
            }
        }
        //horizontal
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == symbol){
                if(board[i].charAt(1) == symbol && board[i].charAt(2) == symbol) return true;
            }
        }
        return false;
    }
}
