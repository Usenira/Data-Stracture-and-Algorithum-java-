package KARN.JAVABOOTCAMP.SearchingAlgorithum.LINEARSEARCH;

public class searchinStrings {
    
    public static void main(String[] args) {
        String str = "niranjan";

       System.out.println( Search1(str, 'n'));
    }

    static boolean Search1(String str, char target) {
        if(str.length() == 0) {
            return false;
        }


        for (char ch : str.toCharArray()) {
            if(ch == target) {
                return true;
            }
        }
        return false;
    }


    static boolean Search(String str, char target) {
        if(str.length() == 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if(target == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
