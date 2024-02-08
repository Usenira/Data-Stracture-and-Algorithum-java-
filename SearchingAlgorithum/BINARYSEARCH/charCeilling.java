package KARN.JAVABOOTCAMP.SearchingAlgorithum.BINARYSEARCH;

public class charCeilling {
    
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};

        System.out.println(((char)ceillingOf(letters, 'e')));
    }

    static int ceillingOf(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;


        while (start <= end) {
            int mid = start + (end-start)/2; 
    
            if(target < letters[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
}
return letters[start % letters.length];
}}

