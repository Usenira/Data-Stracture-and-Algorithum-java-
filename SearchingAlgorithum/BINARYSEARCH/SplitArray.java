package KARN.JAVABOOTCAMP.SearchingAlgorithum.BINARYSEARCH;


public class SplitArray {
    
    public static void main(String[] args) {
       int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));

    }

    public static int splitArray(int[] nums, int k) {
        
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            //this start will contains maximum value from the array
             end += nums[i];
        }

        //binarySearch

        while (start < end) {
            //try for the middle as potential ans

            int mid = start + (end-start)/2;

            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if(sum + num > mid) {
                    //you can't add this in this subarray, make new one
                    //say you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if(pieces > k) {
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return end;//here start == end
    }
}
