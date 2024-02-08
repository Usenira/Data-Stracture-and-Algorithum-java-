package Recursion;


public class Reverse {

    static int sum = 0;
    static void rvrse(int n) {
        if(n == 0) {
            return ;
        }
        int rem = n%10;
        sum = sum * 10 + rem;
         rvrse(n/10);
    }

    static int rev2(int n) {
        //sometimes you might need some additional veriables in the argument 
        //in that case, make another function

        int digits = (int)(Math.log10(n))+1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if(n%10 == n) {
            return n;
        }

        int rem = n%10;
        return (int) (rem * Math.pow(10, digits-1) + helper(n/10, digits-1));
    }

    //PALINDROME 
    static boolean palin(int n) {
        return n == rev2(n);
    }

    static int countZeros(int n,int c) {
        return helper1(n, 0);

    }

    //special pattern , how to pass a value to above calls
    private static int helper1(int n, int c) {
      if(n == 0) {
        return c;
      }  
      int rem = n%10;
      if(rem ==0) {
        return helper1(n/10, c+1);
      }
      return helper1(n/10, c);
    }

    public static void main(String[] args) {
        // rvrse(1234);
        // System.out.println(sum);
        // System.out.println(rev2(7896));

        // System.out.println(palin(1281));
        System.out.println(countZeros(60079, 0));
    }
}
