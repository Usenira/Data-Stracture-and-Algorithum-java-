package QuickSort;

import java.util.Arrays;

public class QuickSort {
    //pivot:choose any element then after first pass all the element < pivot will be on leftside of pivot.
    //  & all element > pivot will be right side
    //Recurence relation: t(n) = t(k) + t(n-k-1) + O(n) //tc:O(n2) 
    // linear recurence relation //worst time complexity// this happen when the pivot element either at the 0/first index or last index. 
    // best tc:o(n2) when the pivot element is right in the middle //T(n) = t(n/2)+t(n/2)+t(n);


    //mergeSort is better for linkedList due to continue memory allocation
    //in_place : is prefered for arrays while ms takes O(n) space complexity

    //hybrid sorting algorithum(tim sort): merge sort + incertion sort
    
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,4,3,2};
      sort(arr, 0, arr.length-1);
      System.out.println(Arrays.toString(arr));


    }
    static void sort(int[] arr,int low, int hi) {
        if(low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s+(e-s)/2;
        int pivot = arr[m];
        while (s <= e) {
            while (arr[s] < pivot) {
               s++; 
            }
            while (arr[e] > pivot) {
                e--;
            }

            //also a reason why if its already sorted it will not swap
            if(s<=e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        // now my pivot is at correct index, please sort two halves now
        //for left side
        sort(arr, low, e);
        //for right side
        sort(arr, s, hi);
    }

}
