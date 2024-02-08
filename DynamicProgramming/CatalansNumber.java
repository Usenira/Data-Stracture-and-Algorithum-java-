package code.Nira.DynamicProgramming;

import java.util.Arrays;

public class CatalansNumber {

    public static int CatalanRec(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
         ans += CatalanRec(i) * CatalanRec(n-i-1);
    }
    return ans;
}

public static int CatalanMemo(int n, int dp[]) {
    if(n == 0 || n == 1) {
        return 1;
    }
    if(dp[n] != -1) {
        return dp[n];
    }
    int ans = 0;
    for(int i=0; i<n; i++) {
     ans += CatalanMemo(i, dp) * CatalanMemo(n-i-1, dp);
}
return dp[n] = ans;

}
public static int CatalanTab(int n) {
    int dp[] =  new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2; i<=n; i++) {
        for(int j=0; j<=i-1; j++) {
            dp[i] += dp[j] * dp[i-j-1];
        }
    }
    return dp[n];
}
    
    public static void main(String[] args) {
        int n = 4;
        System.out.print("catala's Number"+ "(" + n+") = ");

        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // System.out.println(CatalanMemo(n, dp));

        System.out.println(CatalanTab(n));
    }
}
