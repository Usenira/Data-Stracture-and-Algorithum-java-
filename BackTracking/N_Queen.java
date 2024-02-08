package BackTracking;

public class N_Queen {
    //Recurenece Relation : T(N) = N*(N-1) + O(N^2) // time complexity: O(n!)worst tc
    //N*(N-1) means n is the no of row ans (n-1) : is for every row the recursion call will run and n^2: is the safe place check for Queens
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    private static boolean isSaefe(boolean[][] board, int row, int col) {
        //check for vertical row
        for(int i=0; i<row; i++) {
            if(board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row,col);
        for(int i=1; i<=maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }

        //diagonal right
        int maxRight = Math.min(row,board.length-col-1); // col:board.length-col-1 because Queen can't go outside from the column
        for(int i=1; i<=maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    static int queens(boolean[][] board, int row) {
        //here we don't pass column because in every recusion call the column will start from 0 -> col.length
        if(row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count  = 0;
        //placing the queens and checking for every row and col
        for(int col = 0; col < board.length; col++) {
            //place the queen if it is safe
            if(isSaefe(board,row,col)) {
                board[row][col] = true;// when ths place is safe 
                count += queens(board, row+1);
                board[row][col] = false;// backtracing : 
            }
        }
        return count;
    }

   private static void display(boolean[][] board) {
    for(boolean[] row: board) {
        for(boolean element: row) {
            if(element) {
                System.out.print('Q');
            }else {
                System.out.print('X');
            }
        }
        System.out.println();
    }
   }
}
