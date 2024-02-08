package MathLogic;

public class SquareRoot {
    
    public static void main(String[] args) {
        int n = 40;
        int p = 3; //p is number of decimal place 
        System.out.printf("%.3f", BinarySqRoot(n, p));
        //"%.3f" gives --: up to 3 decimal place number

    }

    static double BinarySqRoot(int n, int p) {

        int s = 0;
        int e = n;
        double root = 0.0;
        while (s<= e) {
            int m = s+(e-s)/2;

            if(m*m == n) {
                return m;
            } else if(m*m > n) {
                e = m-1;
            } else {
                s = m+1;
            }

            double incr = 0.1;
            for(int i=0; i<p; i++) {
                while(root * root <= n) {
                    root += incr;
                }

                root -= incr;
                incr /= 10;
            }
           
        }
        return root;
    }
}
