package sortingAlgorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNum {
    
    public static void main(String[] args) {
        int[] arr = {2,0,1,5};
        System.out.println(NumMissing(arr));
    }

    static List<Integer> NumMissing(int[] arr) {

        int i=0;
        while (i < arr.length) {
            int correct = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
        //Search for missing num
        // case - 1 // when the current index isn't present that is the missing element form thr array

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {

            if(arr[j] != j+1) {
                ans.add(j+1);
            }
        }
        //case - 2 //when every element is present but except the n
        return ans;

    }
    
    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
