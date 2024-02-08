package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombination {
    
    public static void main(String[] args) {
        // String up = "78";
        // List<String> ans = LetterCombations1("", up);
        // System.out.println(ans);
        dice("", 4);

    }

    static List<String> LetterCombations(String p, String up) {
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for(int i= (digit-1)*3; i<digit*3; i++) {
            char ch = (char)('a'+i);
            ans.addAll(LetterCombations(p + ch, up.substring(1)));
        }
        return ans;

    }

    static List<String> LetterCombations1(String p, String up) {
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
           if(!p.isEmpty()){
            list.add(p);
            return list;
            }
            else{
                return list;
            }
        }

        int digit = up.charAt(0) - '0'; // this will convert '2' into 2

        List<String> list = new ArrayList<>();
        if(digit>=2 && digit<=6) {
            for(int i=(digit-2)*3; i<(digit-1)*3; i++) {
                char ch  = (char)('a' + i);
                list.addAll(LetterCombations1(p+ch, up.substring(1)));
            }
        }

        if(digit == 7) {
            for(int i = (digit-2) * 3; i<= (digit-1) *3; i++) {
                char ch  = (char)('a' + i);
                list.addAll(LetterCombations1(p+ch, up.substring(1)));
            }
        }

        if(digit == 8) {
            for(int i=((digit-2)*3)+1; i<((digit-1)*3)+1; i++) {
               char ch  = (char)('a' + i);
                list.addAll(LetterCombations1(p+ch, up.substring(1))); 
            }
        }

        if(digit == 9) {
            for(int i = ((digit-2) * 3)+1; i<= ((digit-1) *3)+1; i++) {
                char ch  = (char)('a' + i);
                list.addAll(LetterCombations1(p+ch, up.substring(1)));
            }
        }

return list;
    }


    static void dice(String p, int target) {
        if(target == 0) {
            System.out.println(p);
            return;
        }

        for(int i=1; i<=6 && i<=target; i++) {
            dice(p+i, target-i);
        }
    }
}
