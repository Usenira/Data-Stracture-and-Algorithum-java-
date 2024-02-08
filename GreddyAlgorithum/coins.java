package code.Nira.GreddyAlgorithum;
import java.util.*;
public class coins {
    public static void main(String[] args) {
        Integer ruppi[] = {1,2,5,10,20,50,100,500,2000};
        Arrays.sort(ruppi, Comparator.reverseOrder());
        int count = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < ruppi.length; i++) {
            if(ruppi[i] <= amount) {
                while (ruppi[i]<=amount) {
                    count++;
                    ans.add(ruppi[i]);
                    amount = amount-ruppi[i];
                }
            }
        }
        System.out.println("total amount = " + count);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        System.out.println();
    }
}
