package sortingAlgorithum;

import java.util.Arrays;

public class insertionSort {
    
    public static void main(String[] args) {
        int[] arr = {3,4,5,2,1};
        Insertion(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void Insertion(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j-1] > arr[j]) {
                    swap(arr, j-1,j);
                    
                } else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
