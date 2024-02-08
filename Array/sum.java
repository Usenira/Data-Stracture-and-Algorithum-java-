

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sum {
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);

    }
     public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            //skip duplicate element for i
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                   // Found a triplet with zero sum              
                if(sum == 0) {
                  ans.add(Arrays.asList(nums[i], nums[j], nums[k]));  
                
                //skip duplicate element for j
                 while (j < k && nums[j] == nums[j+1]) {
                    j++;
                 }
                // Skip duplicate elements for k
                 while (j < k && nums[k] == nums[k-1]) {
                    k--;
                 }

                 // Move the pointers
                 j++;
                 k--;
                } else if(sum < 0 ){
                 // Sum is less than zero, increment j to increase the sum
                    j++;
                }else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }

            }
        }
        return ans;
     }
}
