package sortingAlgorithum;

public class findDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,4,2};
        System.out.println(duplicateElement(nums));

    }

    static int duplicateElement(int[] arr) {
        int i=0;
        while (i<arr.length) {

            if(arr[i] != i+1) {
            if(arr[i] != arr[arr[i]-1]) {
                swap(arr, i, arr[i]-1);
            } else {
                return arr[i];
            }
        } else {
            i++;
        }
        }
        return -1;
    }
    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
