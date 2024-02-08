package KARN.JAVABOOTCAMP.SearchingAlgorithum.BINARYSEARCH;

public class OrderAgnosticBS {
    
    public static void main(String[] args) {
        int[] arr = {98,89,78,67,56,45,34,23,21,11,8,6};
        System.out.println(binary(arr, 89));
    }

    static int binary(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        //check ORDER AGNOSTIC means if the array is ascending or decending order
        //find the array is sorted in ascending or decending
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end-start) / 2;
            if(target == arr[mid]) {
                return mid;
            } 

            if(isAscending) {
                if(target < arr[mid]) {
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            } else {
                if(target < arr[mid]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
