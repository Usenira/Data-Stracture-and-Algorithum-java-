package code.Nira.HashMap;

import java.util.HashSet;

public class hashset {
    public static void main(String[] args) {
        int num[] = {4,3,2,1,5,6,7,4,3,1,7};

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<num.length; i++) {
            set.add(num[i]);

        }
        System.out.println(set.size()+" ");
    }
}
