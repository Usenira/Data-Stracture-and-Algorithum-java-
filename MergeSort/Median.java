package MergeSort;

public class Median {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0;
        int[] arr = merge(nums1, nums2);
        if(arr.length % 2 == 0) {
            mid = (double)((arr[arr.length/2]) + (arr[(arr.length/2)-1]))/2; 
        } else {
            mid =arr[arr.length/2];
        }
        return mid;
    }
    static int[] merge(int[] n1, int[] n2) {
        int[] mix = new int[n1.length + n2.length];

        int i=0,j=0,k=0;

        while(i<n1.length && j<n2.length) {
            if(n1[i] < n2[j]) {
                mix[k] = n1[i];
                i++;
            } else {
                mix[k] = n2[j];
                j++;
            }
            k++;
        }
         while(i<n1.length) {
             mix[k] = n1[i];
             i++;
             k++;
         }

         while(j<n2.length) {
             mix[k] = n2[j];
             j++;
             k++;
         }
         return mix;
    }
}
