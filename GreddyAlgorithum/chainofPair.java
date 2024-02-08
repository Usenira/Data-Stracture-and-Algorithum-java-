package code.Nira.GreddyAlgorithum;
import java.util.*;
public class chainofPair {
    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainlen = 1;
        int pairsEnd = pairs[0][1];
        for (int i = 0; i < pairs.length; i++) {
            if(pairs[i][0] > pairsEnd) {
                chainlen ++;
                pairsEnd = pairs[i][1];
            } 
        }
        System.out.println("chains of length = " + chainlen);
    }
}
