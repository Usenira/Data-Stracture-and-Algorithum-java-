package Pattren;

public class toppi {
    
    public static void main(String[] args) {

        interesting(4);
    }
    static void patt(int n) {
        for (int i = 1; i <= 2*n; i++) {
            int c = i>n ?  2*n-i : i;
            for(int s =1; s<=n-c; s++) {
                System.out.print(" ");
            }
            for(int col=c; col>=1; col--) {
                System.out.print(col);
            }
            for(int col=2; col<=c; col++) {
                System.out.print(col);
            }
           
            System.out.println();
        }
    }

    static void interesting(int n) {
        int originalN = n;
        n = 2*n;
        for(int row=0; row<=n; row++) {
            for(int col=0; col<=n; col++) {
                int atEveryIndex = originalN - (Math.min(Math.min(row,col), Math.min(n-row,n-col)));
                System.out.print(atEveryIndex);
            }
            System.out.println();
        }
    }
}
