package code.Nira.Heap;

public class HeapSort {

    public static void heapsortt(int arr[]) {
        int n = arr.length;
        for (int i = n/2; i >= 0; i--) {
            hepify(arr,i, n);

        }

        for (int i = n-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            hepify(arr,0, i);
        }

    }

    public static void hepify(int arr[], int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int max = i;

        if(left < size && arr[max] < arr[left]) {
             max = left;
        }
        if(right < size && arr[max] < arr[right]) {
            max = right;
        } 

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            hepify(arr, max, size);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};
        heapsortt(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
