package BinarySearchTrees;

import java.util.ArrayList;

public class BalancedBST {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    } 

    //CONVERT BST TO BALANCED BST
    public static Node balancedBST(Node root) {
        //inorder sequence
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInorder(root, inOrder);
        //sorted inorder -> balanced bst
        root = CreateBST(inOrder, 0, inOrder.size()-1);
            return root;
    }

    //Create BST
    public static Node CreateBST(ArrayList<Integer>inOrder, int s, int e) {
        if(s>e) {
            return null;
        }
        int m = (s+e)/2;
        Node root = new Node(m);
        root.left = CreateBST(inOrder, s, m-1);
        root.right = CreateBST(inOrder, m+1, e);
        return root;
    }

    //Inorder  function
    public static void getInorder(Node root, ArrayList<Integer> inOrder) {
        if(root == null) {
            return;
        }
        getInorder(root.left,inOrder );
        inOrder.add(root.data);
        getInorder(root.right, inOrder);
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    } 
    public static void main(String[] args) {
        
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.right = new Node(3);

        root.right = new Node(10);
        root.right.left= new Node(11);
        root.right.right= new Node(12);
        root.right.right.left= new Node(13);
        root.right.right.right = new Node(14);

        root = balancedBST(root);
        preOrder(root);
    }
}
