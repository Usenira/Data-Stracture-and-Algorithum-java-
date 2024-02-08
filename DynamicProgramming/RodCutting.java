package code.Nira.DynamicProgramming;
import java.util.*;
public class RodCutting {

    public static int rodNapSack(int Length[], int Prices[], int rodLenght) {
        int n = Length.length;
        int dp[][] = new int[n+1][rodLenght+1];
        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<rodLenght+1; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<rodLenght+1; j++) {
                if(Length[i-1] <= j) {
                    dp[i][j] = Math.max((Prices[i-1]+ dp[i][j-Length[i-1]]), dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodLenght];
    }
    public static void main(String[] args) {
        int Length[] = {1,2,3,4,5,6,7,8};
        int Prices[] = {1,5,8,9,10,17,17,20};
        int rodLenght = 8;
        System.out.println(rodNapSack(Length, Prices, rodLenght));
    }
}
