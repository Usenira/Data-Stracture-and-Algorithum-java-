package Recursion;

public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,12,1,2,3,4};
        System.out.println(Search(arr, 0, arr.length-1, 12));

    }

    static int Search(int[] arr, int s, int e, int target) {
        if(s>e) {
            return -1;
        }

        int m = s+(e-s)/2;
        if(arr[m] == target) {
            return m;
        }
        if(arr[s] <= arr[m]) {
            //this check first half array is sorted then Search in the first part of the array
            if(target >= arr[s] && target <= arr[m]) {
               return Search(arr, s, m-1, target);
            } else {
              return Search(arr, m+1, e, target);
            }
        }
        if(arr[s] >= arr[m]) { // this check is first part array isn't sorted then Search in second half of the array
            if(target >= arr[m] && target <= arr[e]) {
                return Search(arr, m+1, e, target);
            } else {
                return Search(arr, s, m-1, target);
            }
        }
        return -1;
    }
}
