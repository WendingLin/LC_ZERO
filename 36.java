class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j = 0; j<9; j++){
                if(board[i][j]!='.' && !row.add(board[i][j])) return false;
                if(board[j][i]!='.' && !column.add(board[j][i])) return false;
                
                int rowindex = 3*(i/3)+j/3;
                int columnindex = 3*(i%3)+j%3;
                if(board[rowindex][columnindex]!='.' && !cube.add(board[rowindex][columnindex])) return false;
            }
        }
        return true;
    }
}
