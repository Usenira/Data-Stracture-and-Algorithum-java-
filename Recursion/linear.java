package Recursion;

import java.util.ArrayList;

public class linear {
    public static void main(String[] args) {
        int[] arr = {3,4,6,6,65};
        // System.out.println(Search(arr, 0, 6));
    //    FindAllIndex(arr, 0, 6);
    //    System.out.println(list);

    System.out.println(FindAllIndex1(arr, 0, 6, new ArrayList<>()));
    System.out.println(FindAllIndex2(arr, 0, 6));
    }
    static int Search(int[] arr,int i, int target) {
        if(i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        } return Search(arr, i+1, target);
    }

    //FIND ALL THE TARGET INDEX

    //here list is set from outside of the function
    static ArrayList<Integer> list = new ArrayList<>();
    static void FindAllIndex(int[] arr,int i, int target) {
        if(i == arr.length) {
            return;
        }
        if (arr[i] == target) {
            list.add(i);
        } 
         FindAllIndex(arr, i+1, target);
    }

    //here list is taken  as an argument so we can return the list
    static ArrayList FindAllIndex1(int[] arr,int i, int target, ArrayList<Integer>list) {
        if(i == arr.length) {
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        } 
        return FindAllIndex1(arr, i+1, target, list);
    }

    static ArrayList<Integer> FindAllIndex2(int[] arr,int i, int target) {
        ArrayList<Integer> list = new ArrayList<>();

        if(i == arr.length) {
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        } 
        ArrayList<Integer> AnsFromBelowFunctionCall = FindAllIndex2(arr, i+1, target);
        //here everyFunction call the ArrayList will create new one so that's why this Approach isn't optimised.
        list.addAll(AnsFromBelowFunctionCall);
        return list;
    }
}
