package KARN.JAVABOOTCAMP.SearchingAlgorithum.LINEARSEARCH;

public class Wealth {
    
    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}, {4,5,6,7}};
        
        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;

        // for (int r = 0; r < accounts.length; r++) {
        //     int sum = 0;
        //     for (int c = 0; c < accounts[r].length; c++) {
        //         sum += accounts[r][c];
        //     }
        //     if(max < sum) {
        //         max = sum;
        //     } 
        // }

        for (int[] r : accounts) {
            int sum=0;
            for (int c : r) {
                sum += c;
            }
            if(max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
