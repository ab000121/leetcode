class Solution {
    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        
        return backtrack(board , 0 , n );
    }


    public int backtrack(char[][] board , int row , int n){
        if(row == n){
            
            return 1;
        }
        int count = 0;
        for(int j = 0; j < n; j++){
            if(isSafe(board , row , j , n)){
                board[row][j] = 'Q';
                count += backtrack(board , row+1 , n);
                board[row][j]='.';
            }
            
        }

        return count;
    }

    public boolean isSafe(char board[][] , int row , int j , int n){

        //checking in column
        for(int i = row; i >= 0; i--){
            if(board[i][j] == 'Q') return false;
        }

        //checking left diagonal
        int i = row;  int col = j;
        while( i >= 0 && col >= 0){
            if(board[i][col] == 'Q') return false;
            i--; col--;
        }

        //checking right diagonal
        i = row; col = j;
        while(i >= 0 && col < n){
            if(board[i][col] == 'Q') return false;
            i--; col++;
        }
        return true;
    }
}