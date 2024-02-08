package code.Nira.HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashmapcode {
    static class HashMap<k,v> {
        private class Node {
        k key;
        v val;

        public Node(k key, v val) {
            this.key = key;
            this.val = val;
        }
        }

    private int n ;
    private int N;
    private LinkedList<Node> bucket[];
    private V val;

    @SuppressWarnings("unchecked")
    public HashMap () {
        this.N = 4;
        this.bucket = new LinkedList[4];
        for(int i=0; i<4; i++) {
            this.bucket[i] = new LinkedList<>();
        }
        }

        private int hashFunction(k key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInll(k key, int bi) {
            LinkedList<Node> ll = bucket[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked");

        private void reash() {

            LinkedList<Node> oldbuck[] = bucket;
            bucket = new LinkedList[N*2];
            N = 2*N;
            for(int i=0; i<bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }
            for(int i=0; i<oldbuck.length; i++) {
                LinkedList<Node> ll = oldbuck[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.val);
                } 
            }
        }
        public void put(k key, v val) {
            int bi = hashFunction(key);
            int di = searchInll(key, bi);

            if(di != -1) {
                Node node = bucket[bi].get(di);
                node.val = val;
            } else {
                bucket[bi].add(new Node(key, val));
                n++;
            }

            double lamda = (double)n/N;
            if(lamda > 2.0) {
                reash();
            }
        }

        public boolean containsKey(k key) {
            int bi = hashFunction(key);
            int di = searchInll(key, bi);

            if(di != -1) {
               return true;
            } else {
             return false;
            }
        }

        public v get(k key) {
            int bi = hashFunction(key);
            int di = searchInll(key, bi);

            if(di != -1) {
                Node node = bucket[bi].get(di);
                return node.val;
            } else {
                return null;
            }
        }

        public v remove(k key) {
            int bi = hashFunction(key);
            int di = searchInll(key, bi);

            if(di != -1) {
                Node node = bucket[bi].remove(di);
                n--;
               return node.val;
            } else {
                return null;
            }

        }

        public ArrayList<k> keyset() {
            ArrayList<k> keys = new ArrayList<>();

            for(int i=0; i<bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

    public boolean isEmpty() {
        return n == 0;
    }
}
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("china", 150);
        hm.put("us", 50);
        hm.put("nepal", 599);
        ArrayList<String> keys = hm.keyset();
        for(String key : keys) {
            System.out.println(key);
        }
    }
}
