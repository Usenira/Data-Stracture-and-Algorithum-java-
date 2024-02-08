package code.Nira.DynamicProgramming;
import java.util.*;
public class Conversion {
    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if( i==0 || j == 0) {
                    dp[i][0] = 0;
             }
            }
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+ 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int StringConvert(String s1, String s2) {
        int Leng1 = s1.length();
        int Leng2 = s2.length();
        int ans = 0;
        ans += Leng1 - lcs(s1, s2);
        ans += Leng2 - lcs(s1, s2);
        return ans;
    }
    public static void main(String[] args) {
        String s1 = "pear";
        String s2 = "sea";  
        
        System.out.println(StringConvert(s1, s2));
    }
}
