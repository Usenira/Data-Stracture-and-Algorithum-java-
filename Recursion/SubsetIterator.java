package Recursion;
import java.util.Arrays;
import java.util.ArrayList;
import java .util.List;

public class SubsetIterator {
    
    //Time complexity:O(n*2^n); // here n : for nob of levels , 2^n : for each level the number of subset is double

    //sc: O(n * 2^n ); total subset:2^n// n is each subset taken by space;
    public static void main(String[] args) {
        // int[] arr = {1,2,3};
        // List<List<Integer>> ans = Iterter(arr);
        // for(List<Integer> list : ans) {
        // System.out.println(list);
        
        int[] arr = {1,2,2};
         List<List<Integer>> ans = duplicateArray(arr);
        for(List<Integer> list : ans) {
        System.out.println(list);

        } 
    }

   static List<List<Integer>> Iterter(int[] arr) {

    List<List<Integer>> outer = new ArrayList<>();

    outer.add(new ArrayList<>());

    for(int num:arr) {
        int n = outer.size();
        //here n = size of the outer list
        for(int i=0; i<n; i++) {
            List<Integer> internal = new ArrayList<>(outer.get(i));// internal list contains the copy of outer list
            internal.add(num); // then add the num into the internal list
            outer.add(internal);

        }
    }
    return outer;

   }

   //if array have duplicate then 
     static List<List<Integer>> duplicateArray(int[] arr) {
        Arrays.sort(arr);

    List<List<Integer>> outer = new ArrayList<>();
    outer.add(new ArrayList<>());

    int start = 0;
    int end = 0;
    for(int i=0; i<arr.length; i++) {
        start = 0;
        //if current and previous element is same s = e+1
        if(i > 0 && arr[i] == arr[i-1]){
            start = end+1;
        }

        end = outer.size()-1;
        int n = outer.size();
        //here n = size of the outer list
        for(int j=start; j<n; j++) {
            List<Integer> internal = new ArrayList<>(outer.get(j));// internal list contains the copy of outer list
            internal.add(arr[i]); // then add the num into the internal list
            outer.add(internal);
        }
        
    }
    return outer;

   }

}
