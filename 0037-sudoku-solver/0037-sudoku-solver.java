class Solution {
    public void solveSudoku(char[][] board) {
        
        backtrack(board , 0 , 0);
    }

    public boolean backtrack(char[][] board , int i , int j){
        if(i == 9) return true;


        if(j == 9){
            return backtrack(board, i + 1, 0);
        }

        if( board[i][j] != '.') return backtrack(board , i , j+1);

        for(int digit = 1; digit <= 9; digit++){
            if(isValid(board , i , j , (char) (digit + '0'))){
                board[i][j] = (char) (digit + '0');
                if(backtrack(board , i , j+1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }



    public boolean isValid(char[][] board , int i , int j , char digit){

        // checking horizontally
        for(int row = 0 ; row < 9; row++){
            if(board[row][j] == digit) return false;
        }

        //checking vertically
        for(int col = 0; col < 9; col++){
            if(board[i][col] == digit) return false;
        }

        //checking in grid
        int startRow = (i/3)*3;
        int startCol = (j/3)*3;
        for(int row = startRow; row < startRow+3; row++){
            for(int col = startCol; col < startCol+3; col++){
                if(board[row][col] == digit) return false;
            }
        }


        return true;
    }
}