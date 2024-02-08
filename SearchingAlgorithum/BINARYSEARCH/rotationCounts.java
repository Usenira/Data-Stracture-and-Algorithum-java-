package KARN.JAVABOOTCAMP.SearchingAlgorithum.BINARYSEARCH;

public class rotationCounts {
    
    public static void main(String[] args) {
        int[] arr = {11,11,12,11,11};//duplicate array //ans-3
        // int[] arr = {4,5,6,7,2,1};//distinct array //ans-4
        // int[] arr = {1,2,3,4,5,6};//no ratated array //ans-0
        System.out.println(countRotations(arr));
    }

    private static int countRotations(int[] arr) {
        // int pivot = FindPivot(arr);//use this for non- duplicate array

        int pivot = FindPivotInDuplicate(arr);
        return pivot+1;
    }



    // use this for distinct element array

    static int FindPivot(int[] arr) {
        int start =0;
        int end = arr.length-1;

        while (start<=end) {
            int mid = start+(end-start)/2;

            //4 cases here
            if(mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            if(arr[mid] <= arr[start]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    // Q = FIND the pivot element in an duplicate array 
    static int FindPivotInDuplicate(int[] arr) {
        int start =0;
        int end = arr.length-1;

        while (start<=end) {
            int mid = start+(end-start)/2;

            //4 cases here
            if(mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
                //if elements at middle, start ,end are equal then just skip the duplicate

                if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
                    //skip the duplicates
                    //NOTE: What if these elements at start and end were the pivot
                    //check if start is pivot
                    if(arr[start] > arr[start+1]) {
                        return start;
                    }
                    start++;

                    //check if end is pivot
                    if(arr[end] < arr[end-1]) {
                        return end-1;
                    }
                    end--;
                }
                //left side is sorted, so pivot should be in right
                else if(arr[start] < arr[mid] || (arr[mid] > arr[end])) {
                    start = mid+1;
                } else {
                    end = mid - 1;
                }
        }
        return -1;
    }
}
