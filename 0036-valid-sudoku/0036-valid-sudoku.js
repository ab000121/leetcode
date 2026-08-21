/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    
    for(let row=0;row<9;row++){
        for(let col=0;col<9;col++){
            if(board[row][col] != '.'){
                if(!isValid(board,row,col)) return false;
            }
                
        }
    }

    return true;
};

function isValid(board,row,col){
    for(let c=0; c<9; c++){
        if(c!=col && board[row][c] === board[row][col]) return false;
    }

    for(let r=0; r<9; r++){
        if(r!=row && board[r][col] === board[row][col]) return false;
    }

    const gridRow = Math.floor(row/3)*3;
    const gridCol = Math.floor(col/3)*3;

    for(let gRow=gridRow; gRow<gridRow+3;gRow++){
        for(let gCol=gridCol; gCol<gridCol+3;gCol++){
            if(gRow!=row && gCol!=col && board[gRow][gCol]===board[row][col]) return false;
        }
    }
    
    return true;
}

