package BitwiseOperator;

public class SetBits {
    
    public static void main(String[] args) {
        int n = 9;
        System.out.println(SetBitss(n));
        // int count = 0;
        // while (n>0) {
        //     if((n & 1) == 1) {
        //         count++;
        //     }
        //     n = n >> 1;
        // }
        // System.out.println(count);
    }
    private static int SetBitss(int n) {
        int count = 0;
        while (n>0) {
            count++;
            n -= (n & -n);
            //n = n & (n-1);
        }
        return count;
    }

}
