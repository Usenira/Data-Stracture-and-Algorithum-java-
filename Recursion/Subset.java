package Recursion;

import java.util.ArrayList;

public class Subset {
    // subset: non-adjecent collection
    // subset is for array and subsequence is for string
    public static void main(String[] args) {
        String up = "abc";
        // SubSequence(" ", up); 
        // System.out.println(SubSequence1("", up));
        SubSequenceAscii(" ", up);
        System.out.println(SubSequenceAssci1(" ", up));
    }
     static void SubSequence(String p, String up) {// here p : processed //up: unProcessed
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        SubSequence(p+ch, up.substring(1));// its taking
        SubSequence(p, up.substring(1));//its not taking the character
    }

    //return ArrayList and don't pass it in argument directly use in body of the function.
      static ArrayList<String> SubSequence1(String p, String up) {// here p : processed //up: unProcessed
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);           
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = SubSequence1(p+ch, up.substring(1));// its taking
        ArrayList<String> right = SubSequence1(p, up.substring(1));//its not taking the characte
         left.addAll(right);
        return left;
      }

    //Subsequence Ascaii

      static void SubSequenceAscii(String p, String up) {// here p : processed //up: unProcessed
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        SubSequenceAscii(p+ch, up.substring(1));// its taking
        SubSequenceAscii(p, up.substring(1));//its not taking the character
        SubSequenceAscii(p + (ch+0), up.substring(1));// add ascii value taking
    }

    // As arrayList return

    static ArrayList<String> SubSequenceAssci1(String p, String up) {// here p : processed //up: unProcessed
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);           
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> first = SubSequenceAssci1(p+ch, up.substring(1));// its taking
        ArrayList<String> second = SubSequenceAssci1(p, up.substring(1));//its not taking the characte
        ArrayList<String> third = SubSequenceAssci1(p + (ch+0), up.substring(1));//its not taking the characte

         first.addAll(second);
         first.addAll(third);
        return first;
      }
}
