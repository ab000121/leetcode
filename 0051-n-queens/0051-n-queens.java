class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res = new ArrayList<>();

        backtrack(board , 0 , n , res);
        return res;
    }



    public void backtrack(char board[][] , int row , int n , List<List<String>> res){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(char[] r : board){
                temp.add(new String(r));
            }
            res.add(temp);
            return;
        }

    
        for(int j = 0; j < n; j++){
            if(isSafe(board , row , j , n)){
                board[row][j] = 'Q';
                backtrack(board , row+1 , n , res);
                board[row][j]='.';
            }
            
        }
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