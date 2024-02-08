package KARN.JAVABOOTCAMP.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Swap {
    
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5};

        Scanner in = new Scanner(System.in);

        int[] arr = new int[5]; // taking input from user
        
        for(int i=0; i<5; i++) {
            arr[i] = in.nextInt();
        }
        swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        //here i & j are the index1 and 2
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
