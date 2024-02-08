package BinaryTree;

import java.util.HashMap;


public class DuplicateSubTree {
    
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    static HashMap<String,Integer> m;
    public static String inOrder(Node root) {
        if(root == null) {
            return "";
        }
        String str = "(";
        str += inOrder(root.left);
        str += Integer.toString(root.data);
        str += inOrder(root.right);
        str += ")";

        if(m.get(str) != null && m.get(str) == 1) {
            System.out.println(root.data);
        }

        if(m.containsKey(str)) {
            m.put(str, m.get(str)+1);
        } else {
            m.put(str, 1);
        }
        return str;
    }

    public static void PrintAllDup(Node root) {
        m = new HashMap<>();
        inOrder(root);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(1);
        root.right.right.right = new Node(2);
        PrintAllDup(root);
    }
}
