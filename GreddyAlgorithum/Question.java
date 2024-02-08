package code.Nira.GreddyAlgorithum;
import java.util.*;
public class Question {
    public static void main(String[] args) {
      int arr[] = {1,1,2};
      int k = 2;
      int n = 3;
      Slove(arr, n, k, 0,0,0);
      System.out.println(ans+" ");
    } 

    public static int ans = 10000000;
    public static void Slove(int a[], int n, int k, int index, int sum, int maxsum) {
        if(k==1) {
            maxsum = Math.min(maxsum, sum);
            sum = 0;
            for (int i = index; i < n; i++) {
                sum += a[i];
            }
            maxsum = Math.max(sum, maxsum);
            ans = Math.min(ans, maxsum);
            return;
        }
        sum = 0;
        for (int i = index; i < n; i++) {
            sum += a[i];
            maxsum = Math.max(maxsum, sum);
            Slove(a, n, k-1, i+1, sum, maxsum);
        }
    }
        
    


    public static int Maxprofit(int price[], int n) {
        int buy = price[0], profit = 0;
        for (int i = 0; i < n; i++) {
            if(buy > price[i]) {
                buy = price[i];
            } else if(price[i] - buy > profit) {
                profit = price[i] - buy;
            }
        }
        return profit;
    }

    public static char[] Lexico(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        for (int i = n-1; i >= 0; i--) {
            k -= i;
            if(k >=0 ) {
                if(k >= 20) {
                    arr[i] ='z';
                    k -= 26;
                }
             else {
                arr[i] = (char) (k+97-1);
                k -= arr[i]-'a' +1;
            }
         } 
         else 
            break;
            k += i;
         
        }
        return arr;
    }

    public static int BalancedPartition(String str, int n) {
        if(n==0) {
            return 0;
        }
        int r=0, l=0;
        int ans=0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'L') {
                l++;
            } else if (str.charAt(i) == 'R') {
                r++;
            }
            if(r == l) {
                ans++;
            }
        }
        return ans;
    }

    public static int kthOdd(int[] range, int k) {
        if(k<=0) {
            return 0;
        }

        int L = range[0];
        int R = range[1];

        if((R & L) > 0) {
            int count = (int) Math.ceil((R-L+1)/2);
            if(k > count) {
                return 0;
            } else {
                return (R-2 * k+2);
            }
         } else {
                int count = (R-L+1)/2;
                if(k > count) {
                    return 0;
                } else {
                    return (R-2 * k+1);
                }
            }
        }
    }

