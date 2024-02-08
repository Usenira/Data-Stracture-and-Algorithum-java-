package BackTracking;

public class sudukoSolver {
    //time complexity : O(9^n^2); sc: o(n2)
    public static void main(String[] args) {
        
        int[][] board = new int[][] {
            {3,0,6,5,0,8,4,0,0},
            {5,2,0,0,0,0,0,0,0},
            {0,8,7,0,0,0,0,3,1},
            {0,0,3,0,1,0,0,8,0},
            {9,0,0,8,6,3,0,0,5},
            {0,5,0,0,9,0,6,0,0},
            {1,3,0,0,0,0,2,5,0},
            {0,0,0,0,0,0,0,7,4},
            {0,0,5,2,0,6,3,0,0}
        };

        if(slove(board)) {
            display(board);
        } else {
            System.out.println("Can't slove");
        }
    }

    static boolean slove(int[][] board){

        int n = board.length;
        int row = -1;
        int col = -1;
        
        boolean emptyLeft = true;

        //this is how we are replacing the row, col, from argument
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;// this check is for every col is empty or not
                    break;
                }
            }
          // if you found some empty  element in row, then break

             if(emptyLeft == false) {
                break;
    }
}
             if(emptyLeft == true) {
             return true;
             //suduko is sloved
    }

        //Recursion + backTrack part 
        for(int number = 1; number<=9; number++){
            if(isSafe(board, row, col, number)) {
                board[row][col] = number;
                if(slove(board)) { //recursion
                    //found the answer
                return true;
             } else {
                    //backtarck
                    board[row][col] = 0;
                }
            }
        }
    return false;
}

static void display(int[][] board){
    for(int[] row: board) {
        for(int num: row) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

    static boolean isSafe(int[][] board, int row,int col, int num) {
         
        //check for row
        for(int i=0; i<board.length; i++) {
            //check if the number is in the row
            if(board[row][col] == num) {
                return false;
            }
        }

        //check for col
        for(int[] nums: board) {
            //check if the number is in thr col
            if(nums[col] == num) {
                return false;
            }
        }

        // now check if the num is present in the 3*3 grid
        // its check in the cube or grid

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row -row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart; r < rowStart+sqrt; r++) { // row of starting grid
            for(int c = colStart; c < colStart+sqrt; c++) { //col of starting grid
                if(board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // char[][] board solution
    public class Solution {
        public void solveSudoku(char[][] board) {
            if(board == null || board.length == 0)
                return;
            solve(board);
        }
        
        public boolean solve(char[][] board){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == '.'){
                        for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                            if(isValid(board, i, j, c)){
                                board[i][j] = c; //Put c for this cell
                                
                                if(solve(board))
                                    return true; //If it's the solution return true
                                else
                                    board[i][j] = '.'; //Otherwise go back
                            }
                        }
                        
                        return false;
                    }
                }
            }
            return true;
        }
        
        private boolean isValid(char[][] board, int row, int col, char c){
            for(int i = 0; i < 9; i++) {
                if(board[i][col] != '.' && board[i][col] == c) return false; //check row
                if(board[row][i] != '.' && board[row][i] == c) return false; //check column
                if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
            }
            return true;
        }
    }
}

