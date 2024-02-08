package code.Nira.BinaryTress;

import java.util.HashMap;

public class Duplicates {
    static HashMap<String, Integer> map ;
    static class Node {
        int data;
        Node left,right;
        Node(int data) {
            this.data=data;
        }
    }
    static String Inorder(Node root) {
        if(root == null) {
            return "";
        }
        String str = "(";
        str += Inorder(root.left);
        str += Integer.toString(root.data);
        str += Inorder(root.right);

        if(map.get(str) != null && map.get(str) == 1) {
            System.out.println(root.data+" ");
        }
        if(map.containsKey(str)) {
            map.put(str, map.get(str)+1);
                } else {
                    map.put(str, 1);
                }
                return str;
    }

    static void printAllDups(Node root) {
        map = new HashMap<>();
        Inorder(root);
    }
    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
    }
}
