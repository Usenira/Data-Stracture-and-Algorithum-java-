package KARN.JAVABOOTCAMP.Array;

import java.lang.reflect.Array;
import java.util.Arrays;


public class MaxandMin {
    
    public static void main(String[] args) {
        int[] arr = {12, 78, 45 ,98, 70};


        Reverse(arr);
        System.out.println(Arrays.toString(arr));
        //    System.out.println(Range(arr, 1, 3));
    //    System.out.println(maxValue(arr));

    }
    static void swap(int[] arr, int i, int j) {
        //here i & j are the index1 and 2
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void Reverse (int[] arr) {
        int start =0;
        int end = arr.length-1;
        while (start < end) {
            swap(arr, start, end);
        
            start++;
            end--;
        }
        
    }

    static int Range(int arr[], int start, int end) {
        int max = arr[0];
        //work on Egde cases
        // if(end > start) {
        //     return -1;
        // }

        // if(arr == null) {
        //     return -1;
        // }


        for(int i=start; i<=end; i++) {
            System.out.print(arr[i]+" ");// for print range


             if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
               
    }


    static int maxValue(int[] arr) {

        int max = arr[0];  //here we intialize with 0th index of arr

        // or you compare with -infinite code is = int max = Integer.MIN_VALUE;
        //FOR MINIMUM you can compare with positive integer. code = int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }


}
