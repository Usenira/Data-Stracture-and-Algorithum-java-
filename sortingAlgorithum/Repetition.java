package sortingAlgorithum;

import java.util.ArrayList;
import java.util.List;

public class Repetition {
    
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
    }
    static List<Integer> find(int[] arr) {
          int i=0;
          List<Integer> ans = new ArrayList<>();
        while (i < arr.length) {
            if(arr[i] != i+1) {
            int correct = arr[i] -1;
            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
             ans.add(i);
            } 
        }else {
                i++;
            }
        }
        return ans;

    }
    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
