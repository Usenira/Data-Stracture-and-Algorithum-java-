package Pattren;

public class star {
    public static void main(String[] args) {
        patternn(5);
        
    }
    static void patternn(int n) {
        for (int row = 0; row <= 2*n-1; row++) {
            //for every row, run the col
            int totalColsInRow  = row>n ? 2*n-row:row;

            int noofSpaces = n - totalColsInRow;
            for (int s = 0; s< noofSpaces; s++) {
                System.out.print(" ");
            }
            for(int col=0; col < totalColsInRow ; col++) {
                System.out.print("* ");
            }
            //when one row is printed , we need to add a newline
            System.out.println();
        }
    }
}
