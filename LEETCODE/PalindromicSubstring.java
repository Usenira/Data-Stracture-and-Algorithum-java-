package JAVABOOTCAMP.LEETCODE;

public class PalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(checkPalindromic(s));
    }

    static boolean checkPalindromic(String s) {

        for(int i=0; i<s.length()/2; i++) {
           if( s.charAt(i) == s.charAt(s.length()-1-i)) {
            return true;
           }
        }
        return false;
    }
}
