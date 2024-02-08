package sortingAlgorithum;

import java.util.Arrays;

public class selectionSort {
    
    public static void main(String[] args) {
        
        int[] arr = {3,2,5,1,4};
        Selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Selection(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
        // find the max item int teh remaining array and swap with correct index
        int last = arr.length-i-1;
        int maxIndex = getMaxIndex(arr, 0, last);
        //swap
        swap(arr, last, maxIndex);
    }
}

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}

