package Recursion;

public class Sorted {
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4};
        System.out.println(isSorted(arr, 0));
    }

    static boolean isSorted(int[] arr, int i) {
        if(i+1 == arr.length) {
            return true;
        }

        return (arr[i] < arr[i+1]) && isSorted(arr, i+1);
}

}