package code.Nira.Heap;

import java.util.ArrayList;

public class tatto {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public int removes() {
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            arr.remove(arr.size()-1);
            heapify(0);
            return data;
        }
        public void heapify(int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int mididx = i;

            if(left < arr.size()-1 && arr.get(mididx) > arr.get(left)) {
                mididx = left;
            }

            if(right < arr.size()-1 && arr.get(mididx) > arr.get(right)) {
                mididx = right;
            }

            if(mididx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(mididx));
                arr.set(mididx, temp);
                heapify(mididx);
            }
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }

    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(3);
        hp.add(2);
        hp.add(1);
        hp.add(5);

        while (!hp.isEmpty()) {
            System.out.println(hp.peek());
            hp.removes();
        }
    }
}
