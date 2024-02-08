package Recursion;

public class binarySearch {
    
    public static void main(String[] args) {
        int[] arr = {4,5,3,2,6,7,8,9};
        System.out.println(Binary(arr, 0, arr.length-1, 3));
    }

    static int Binary(int[] arr, int s, int e, int target) {
        //all values we pass for further recursion call we pass it into argument //like -: start(s), end(e)
        //and if any values is relevent for that paticular body then we pass it in body of the function // like -: mid(m)
        if(s>e) {
            return -1;
        }

        int m = s+(e-s)/2;
        if(target == arr[m]) {
            return m;
        }
        if(target < arr[m]) {
            return Binary(arr, s, m-1, target);
        } 
            return Binary(arr, m+1, e, target);
            }
}
