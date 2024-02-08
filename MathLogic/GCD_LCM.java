package MathLogic;

public class GCD_LCM {
    public static void main(String[] args) {
        // System.out.println(gcd(7, 21));
        System.out.println(Lcm(2, 7));
    }
    static int gcd(int a, int b) {
        if(a==0) {
            return b;
        }
        return gcd(b%a, a);
    }

    static int Lcm(int a, int b) {
        return a*b / gcd(a,b);
    }
}
