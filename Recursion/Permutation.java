package Recursion;
import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        String up = "abc";
       System.out.println(permutationsListCount("", up));

    }

    static void placed(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i=0; i<= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            placed(f + ch + s, up.substring(1));
        }
    }

     static ArrayList<String> permutationsList(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0; i<= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

           ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    static int  permutationsListCount(String p, String up) {
        if(up.isEmpty()) {
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);
        for(int i=0; i<= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

          count = count + permutationsListCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}
