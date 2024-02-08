package TimeComplexity;

public class fibonacci {
    public static void main(String[] args) {
        System.out.println(fibo(50));
    }

    static int fibo(int n) {
        return (int)Math.pow(((1+Math.sqrt(5))/2), n);
    }
}
