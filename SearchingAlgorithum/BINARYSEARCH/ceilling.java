package KARN.JAVABOOTCAMP.SearchingAlgorithum.BINARYSEARCH;

public class ceilling {
    // ceilling = smallest element in array greater or equals to the target num
    // vice - versa Question = FLOOR OF A NUMBER = geatest element in array smallest or equals to the target
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8,78};
        int target = 6;
        System.out.println(ceillingSearch(arr, target));
        System.out.println(floorSearch(arr, target));

    }
    static int ceillingSearch(int[] arr, int target) {
        
        //but what if the target is greater yhan the greatest number in the array
        if(target > arr[arr.length-1]) {
            return -1;
        }
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
        return start;
    }

    static int floorSearch(int[] arr, int target) {
        
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
        return end;
    }
}
