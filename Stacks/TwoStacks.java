package Stacks;

import java.util.Arrays;

public class TwoStacks {
    static int TwoStacks(int x, int[] a, int[] b) {
        return TwoStacks(x, a, b, 0, 0)-1;
    }

    private static int TwoStacks(int x, int[] a, int[] b, int sum, int count) {
        if(sum > x) {
            return count;
        }
        if(a.length == 0 || b.length ==0 ) {
            return count;
        }
        int ans1 = TwoStacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum+a[0], count+1);
        int ans2 = TwoStacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum+b[0], count+1);
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int[] b = {4,2,6,8,7};
        System.out.println(TwoStacks(10, a, b));
    }
}
