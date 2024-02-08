package code.Nira.DynamicProgramming;
import java.util.*;
public class napsack {
    // MEMORIZATION
    public static int nknapshak(int val[], int wt[], int capacity, int n, int dp[][]) {
        if(capacity ==0 || n == 0) {
            return 0;
        }

        if(dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        if(wt[n-1] <= capacity) {
            int ans1 = val[n-1] + nknapshak(val, wt, capacity - wt[n-1], n-1,dp);// valid condition
            int ans2 = nknapshak(val, wt, capacity, n-1, dp);
            dp[n][capacity] = Math.max(ans1, ans2);
            return dp[n][capacity];
                }  else {
                  dp[n][capacity] = nknapshak(val, wt, capacity, n-1,dp);
                  return dp[n][capacity];
                }

    }
    public static void Print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // TABULATION
    public static int Knapsackss(int val[], int wt[], int w) {
        int n = val.length;
        int dp[][] = new int[n+1][w+1];
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;

        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<w+1; j++) {
                int v = val[i-1];
                int W = wt[i-1];
                if(W <= j) {
                    int incProfit = v + dp[i-1][j-W];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        Print(dp);
        return dp[n][w];
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int capacity = 7;

        int dp[][] = new int[val.length+1][capacity+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(Knapsackss(val, wt, capacity));
    }
}
