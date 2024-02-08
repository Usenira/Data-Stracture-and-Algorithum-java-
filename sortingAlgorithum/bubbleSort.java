package sortingAlgorithum;

import java.util.Arrays;

public class bubbleSort {
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Sorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Sorting(int[] arr) {
        boolean swapped;

        //run for steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            //for each steps, max item will come at the last respective index
            for (int j = 1; j < arr.length-i; j++) {
                //swap if the item is smaller then the previous item
                if(arr[j] < arr[j-1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular value of i, it means the array is sorted hence stop the program
            if(!swapped) {// !swapped == swapped == false ,means its didnot swapped
                break;
            }
        }
    }
}
