package code.Nira.GreddyAlgorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Activity {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {5,6,2,3,9,9};

        // if end array is not sorted then we need to sort .
        
        int Activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            Activities[i][0] = i;
            Activities[i][1] = start[i];
            Activities[i][2] = end[i];
        }

        Arrays.sort(Activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(Activities[0][0]);
        int lastEnd = Activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if(Activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(Activities[i][0]);
                lastEnd = Activities[i][2];
            }
        }
        System.out.println("max Activity = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }

    
}
