package KARN.JAVABOOTCAMP.SearchingAlgorithum.LINEARSEARCH;

public class containsEvenNumOfDigit {
    
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896,89,66,5786};

        System.out.println(EvenDigit(nums));

        // System.out.println(digit(-876543));
    }



    static int digits(int nums) {
        if(nums < 0) {
            nums = nums * -1;
        }
        return (int)(Math.log10(nums)) + 1;
    }

    static boolean even(int num) {
        // // 
        // if(digit(num) % 2 == 0) {
        //     return true;
        // }
        // return false;

        return digits(num) % 2 == 0;
    }

    static int digit(int num){

        if(num < 0) {
            num = num * -1;
        }
        if(num == 0) {
            return 1;
        }

        int count = 0;
        while (num > 0) {
            
            count++;
            num = num /10;
        }

        return count;
    }
    static int EvenDigit(int[] nums) {

        
        int count = 0;

        for (int i : nums) {
            if(even(i)){
                count++;
            }
        }
        return count;
    }
}
