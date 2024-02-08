package code.Nira.BinaryTress;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class topView {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    static class Info {
        Node node;
        int hd;

       public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topViewed(Node root) {
        Queue<Info> Q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        Q.add(new Info(root, 0));
        Q.add(null);
        while (!Q.isEmpty()) {
            Info curr = Q.remove();
            if(curr == null) {
                if(Q.isEmpty()) {
                    break;
                } else {
                    Q.add(null);
                }
            }  else {
            if(!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }
                if(curr.node.left != null) {
                    Q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null) {
                    Q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
            }
        } 
    }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        topViewed(root);
    }
}
