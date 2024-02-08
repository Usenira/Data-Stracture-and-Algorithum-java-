package sortingAlgorithum;

import java.util.Arrays;

public class cyclicSort {
    public static void main(String[] args) {
        int[] arr = {3,4,2,1,5};
        Cyclic(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void Cyclic(int[] arr) {
        int i=0;
        while (i < arr.length) {
            int correct = arr[i] -1;
            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }
    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
