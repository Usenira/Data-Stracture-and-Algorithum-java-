package Recursion;

public class Factorial {
    
    public static void main(String[] args) {
        int n = 5;
        printn(5);
        System.out.println(fact(n));
        System.out.println(sum(n));
        System.out.println(sumOfNum(1324));
        System.out.println(productOfDigit(6789));
    }

    static void printn(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printn(--n); // this gives correct answer because first it minus 1 from n then return to the function argument.
        // printn(n--);// this gives error because first it will return.
        //  the value then minus from n so every time the argument "n" going into the function will be same n not minuss minuss
    }

    static int fact(int n) {
        if(n<=1) {
            return 1;
        }

        return n*fact(n-1);
    }

    // sum of n number
    static int sum(int n){
        if(n<=1) {
            return n;
        }
        return n+sum(n-1);
    }

    static int sumOfNum(int n) {
        if(n==0) {
            return 0;
        }

        return sumOfNum(n/10) + (n%10);
    }

     static int productOfDigit(int n) {
        if(n%10 == n) {
            return n;
        }

        return  (n%10) * productOfDigit(n/10);
    }
}
