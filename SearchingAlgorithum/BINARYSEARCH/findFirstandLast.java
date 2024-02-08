package KARN.JAVABOOTCAMP.SearchingAlgorithum.BINARYSEARCH;

public class findFirstandLast {
    
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(searchRange(nums, 8));

    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};


        int start = Search(nums, target, true); // this gives first occerence of the element
        int end = Search(nums, target, false); // this gives last occerence of the element

        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    static int Search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;

         int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if(target < nums[mid]) {
                end = mid-1;
            } else if(target > nums[mid]){
                start = mid+1;
            } else {
                //potential ans found
                ans = mid;
                if(findStartIndex) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return ans;

    }
}
