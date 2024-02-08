package KARN.JAVABOOTCAMP.SearchingAlgorithum;

import java.util.Arrays;

public class SearchIn2DArray {
    

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4,5,6},
            {7,8,9}
        };  // 

        // System.out.println(Arrays.toString(Search(arr, 6)));

        System.out.println(max(arr));

    }

    static int max(int[][] arr) {   //int[] = it means we need to return a integer Array
        

        int max = Integer.MIN_VALUE;
        for (int[] is : arr) {
            for (int is2 : is) {
                if(is2 > max ) {
                    max=is2;
            }
        }
    }
            return max;
    }


    static int[] Search(int[][] arr, int target) {   //int[] = it means we need to return a integer Array
        if(arr.length == 0) {
            return new int[]{-1, -1};
        }
        for (int r = 0; r< arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if(arr[r][c] == target) {
                    return new int[]{r,c}; // Array is not intialized here this function thats why we have to create new object and Also intialize
                }
            }
        }
            return new int[]{-1, -1};
    }
}
