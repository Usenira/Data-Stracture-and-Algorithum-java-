package code.Nira.DynamicProgramming;
import java.util.*;
public class ClimbStairs {
    
    public static int Stairs(int n, int dp[]) {
        if(n == 0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        } else {
            dp[n] = Stairs(n-1, dp) + Stairs(n-2, dp);
            return dp[n];
        }
    }

    public static int CountWaysTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++) {
            if(i == 1) {
                dp[i] = dp[i-1] + 0;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(Stairs(n, dp));
        System.out.println(CountWaysTab(5));
    }
}
