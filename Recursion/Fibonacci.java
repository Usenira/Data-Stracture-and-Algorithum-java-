package JAVABOOTCAMP.Recursion;

public class Fibonacci {
    //fibonacci of number ? 
    //its the sum of thses two num :[ f(n) = f(n-1)+f(n-2)] => Recurence relation

    public static void main(String[] args) {
        System.out.println(fibo(5));
    }

    static int fibo(int n) {
        //base condition
        if(n<2) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
