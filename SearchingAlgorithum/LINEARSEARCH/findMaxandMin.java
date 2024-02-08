package KARN.JAVABOOTCAMP.SearchingAlgorithum.LINEARSEARCH;

public class findMaxandMin {
    
    public static void main(String[] args) {
        
        int[] arr = {12,87,56,98,45,57,76,87,86,86,435};
        System.out.println(Findmin(arr));

    }

    static int Findmin(int[] arr) {
        if(arr.length == 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if(i < min) {
                min = i;
            }
        }
        return min;
    }

    static int Findmax(int[] arr) {
        if(arr.length == 0) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }


}
