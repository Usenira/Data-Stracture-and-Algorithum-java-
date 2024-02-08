package KARN.JAVABOOTCAMP.Array;

import java.util.Arrays;

public class passingFunction {
    
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7};
        System.out.println(Arrays.toString(nums));//[3,4,5,6,7]
        change(nums);
        System.out.println(Arrays.toString(nums));//[99,4,5,6,7];// here array is mutable in java but string are immutable in java
        
    }

    static void change(int arr[]) {
        arr[0] = 99;

    }
}
