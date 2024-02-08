package KARN.JAVABOOTCAMP.SearchingAlgorithum.LINEARSEARCH;

public class Linear {
    
    public static void main(String[] args) {
        int[] arr = {12,34,76,58,89,97};
    System.out.println(linearSearch(arr, 76));

    }

//search in the array : return the index if item found
//otherwise if item not found return -1;

static int linearSearch(int[] arr, int target) {
    if(arr.length == 0) {
        return -1;
    }

    // for(int i=0; i<arr.length; i++) {
    //     if(arr[i] == target) { //check for element at every index if it is = target
    //         return i;
    //     }
    // }

    //Enhace for loop

    for(int element: arr){
        if(element == target) {
            return element;
        }
    }
    return -1;
}
}
