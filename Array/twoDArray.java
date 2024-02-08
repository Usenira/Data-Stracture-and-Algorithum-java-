package KARN.JAVABOOTCAMP.Array;
import java.util.Arrays;
import java.util.Scanner;
public class twoDArray {
    
    public static void main(String[] args) {
        // Syntex : datatype[][] variable_name = new datatype[mention the nob of row][]

        // int[][] arr = new int[3][];

        // int[][] arr = {
        //     {1,2,3},// 0th row index
        //     {1,2,3,4,5},//1st row index
        //     {6,7,8,9} // 2nd index->
        // };

        Scanner it = new Scanner(System.in);


        int[][] arr = new int[3][3];
        System.out.println(arr.length);//print the nob of rows which is 3;


        //taking Input in java
        for(int row=0; row<arr.length; row++){//for each row
            for(int col=0; col<arr[row].length; col++) { // for each col in every row
                arr[col][row] = it.nextInt();
            }
        }

        //output of 2d array
        // for(int row=0; row<arr.length; row++){//for each row
        //     for(int col=0; col<arr.length; col++) { // for each col in every row
        //          System.out.print(arr[col][row]+" ");
        //     }
        //     System.out.println();
        // }

       // or // output using Array.tostring method

        // for(int row=0; row<arr.length; row++) {
        //     System.out.println(Arrays.toString( arr[row]));
        // }

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
            //int[] -> datatype
            //a is the variable
            //arr is reference variable
            
        }

    }
}
