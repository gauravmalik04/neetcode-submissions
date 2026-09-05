class Solution {
    public boolean isValid(char[][] board, int row , int col , char ch){
        for(int j=0;j<9;j++){
            if(j!=col && board[row][j]==ch) return false;
        }
        for(int i=0;i<9;i++){
            if(i!=row && board[i][col]==ch) return false;
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j = sc;j<sc+3;j++){
                if(i!=row && j!=col && board[i][j] == ch) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' &&!isValid(board,i,j,board[i][j])) return false;
            }
        }
        return true;
    }
}
