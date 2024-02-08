package BinarySearchTrees;

import java.util.ArrayList;

public class MergeBST {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer>path) {
        if(root == null) {
            return;
        }
        getInorder(root.left, path);
        path.add(root.data);
        getInorder(root.right, path);
    }

    public static Node mergeSort(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }
        return CreateBST(finalArr, 0, finalArr.size()-1);
    }

    public static Node CreateBST(ArrayList<Integer>arr,int s, int e) {
        if(s>e) {
            return null;
        }
        int m = (s+e)/2;
        Node root = new Node(arr.get(m));
        root.left = CreateBST(arr, s, m-1);
        root.right = CreateBST(arr, m+1, e);
        return root;
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
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeSort(root1, root2);
        preOrder(root);
    }
}
