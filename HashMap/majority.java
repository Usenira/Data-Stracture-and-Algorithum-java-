package code.Nira.HashMap;

import java.util.*;
public class majority {
    public static void main(String[] args) {
        int arr[] = {1,2,2,2,2,1,1,1};
        HashMap<Integer, Integer> Map = new HashMap<>();

        for(int i =0; i<arr.length; i++) {
            // if(Map.containsKey(arr[i])) {
            //     Map.put(arr[i], Map.get(arr[i]) + 1);
            // } else {
            //     Map.put(arr[i], 1);
            // }

            Map.put(arr[i], Map.getOrDefault(arr[i], 0) +1);
        }

        // Set<Integer> keySet = Map.keySet();
        for(Integer key : Map.keySet()) {
            if(Map.get(key) > arr.length/3) {
                System.out.println(key);
            }
        }
    }
}
