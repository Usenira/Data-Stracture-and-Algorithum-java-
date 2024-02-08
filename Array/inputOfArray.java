package KARN.JAVABOOTCAMP.Array;

import java.util.Scanner;

public class inputOfArray {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        arr[0]=22;
        arr[1] = 23;
        arr[2] = 78;
        arr[3] = 0;
        arr[4] = 75;
        //[22,23,78,0,75];
        System.out.println(arr[3]);

        //input using for loops
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();

        }
        for(int i=0; i<arr.length; i++) {
            System.out.print("["+arr[i]+"]");
        }

        for(int num : arr) {  //for every element in array print the element
            System.out.println(num);  // num represent the element of the array
        }
    }
}
