package KARN.JAVABOOTCAMP.SearchingAlgorithum.BINARYSEARCH;

public class binary { 
    //where to use binary Search -
    ///if some question is relrated sorted array 
    ///Sequence based question
    
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14,16,18,20};
        System.out.println(binarySearch(arr, 16));

    }
//return the index
//return -1 if its doesn't exist

    static int binarySearch(int[] arr, int target) {
        
        int start = 0;//here start contains 0th index of array
        int end = arr.length-1; /// here end contains last index of array

        //now find middle element of the array
        while (start <= end) {
            int mid = start + (end-start)/2; // mid contains middle index of array
    
            if(target < arr[mid]) {
                end = mid-1;
            } else if(target > arr[mid]) {
                start = mid+1;
            } else {
                return mid;//ans found
            }
        }
        return -1;
    }
}
