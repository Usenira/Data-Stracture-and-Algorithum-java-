package MathLogic;

import java.util.ArrayList;

public class Factor {
    public static void main(String[] args) {
        factors2(36);
    }

    //time comlexity: O(n)
    static void factors(int n) {
        for(int i=1; i<=n; i++) {
            if(n%i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // time complexity:  O(sqrt(n)) 
    static void factors1(int n) {
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {

                if(n/i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n/i + " ");
                }
            }
        }
    }

    //both time and space with be O(sqrt(n))
    //give the factors in ascending order
    static void factors2(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {

                if(n/i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + " ");
                    list.add(n/i);
                }
            }
        }
        for(int i=list.size()-1; i>=0; i--) {
            System.out.print(list.get(i)+ " ");
        }
    }

}
