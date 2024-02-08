package KARN.JAVABOOTCAMP.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;



public class intro {
 
    public static void main(String[] args) {
        //syntex
        // ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);//add function
        // System.out.println(list);

        //input
        for(int i=0; i<6; i++){
            list.add(sc.nextInt());
        }
           
        
            //get any index value
            for(int i=0; i<7; i++) {
                System.out.println(list.get(0));
            }
        System.out.println(list);
    }
}
