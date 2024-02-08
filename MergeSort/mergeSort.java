package MergeSort;

import java.util.Arrays;

public class mergeSort {
    // MERGE SORT:
    //1:DIVIDE ARRAY INTO 2 PARTS.1 
    //2:GET BOTH PARTS SORTED VIA RECURSION.
    //3:MERGE THEM  AND RETURN.

    //TIME COMPLEXITY:
    //AT EVERY LEVEL N ELEMENT BEING MERGED
    // TC: O(N * LOG(N)) //here first N: is for kth level * log(n) : for every level n/2 comprasion was made ;

    public static void main(String[] args) {
        int[] arr = {8,3,4,12,5,6};
        // System.out.println(Arrays.toString(mergesort(arr)));

        MergeSortInPlace(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    // Arrays.copyOfRange : this gives us the copy of specied range convert into a new array
    static int[] mergesort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }

        int m = arr.length/2;
        int[] left = mergesort(Arrays.copyOfRange(arr,0,m));// this will create new arr object for every function call
        //  but can't reflect in the original object
        int[] right = mergesort(Arrays.copyOfRange(arr,m,arr.length));

        return merge(left,right);
    }
    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i=0;
        int j=0;
        int k=0;
        while(i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while (i<first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j<second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

    // In_Place MergeSort

    static void MergeSortInPlace(int[] arr, int s, int e) {
        if(e-s == 1) {
            return;
        }

        int m = (s+e)/2;

        MergeSortInPlace(arr, s, m);
        MergeSortInPlace(arr, m, e);

        MergeInPlace(arr, s, m, e);
    }

    private static void MergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e-s];
        int i = s;
        int j = m;
        int k = 0;

       

        while (i<m && j<e) {
            if(arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            }else {
                mix[k] = arr[j];
                j++;
            }
            k++;

        }
        while (i<m) {
                mix[k] = arr[i];
                i++;
                k++; 
        }
    
    while (j<e) {

         mix[k] = arr[j];
                j++;
                k++;
    }
    for (int l = 0; l < mix.length; l++) {
        arr[s+l] = mix[l];
    }

    // System.arraycopy(mix,0,s+0,mix.length);

    }

}
