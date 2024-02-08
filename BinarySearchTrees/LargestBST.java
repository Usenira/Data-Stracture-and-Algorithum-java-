package BinarySearchTrees;

import java.util.ArrayList;

public class LargestBST {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

    public Info(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;

    }
}

    public static int maxBST = 0;
    public static Info largstbst(Node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftinfo = largstbst(root.left);
        Info righInfo = largstbst(root.right);

        int size = leftinfo.size + righInfo.size +1 ;
        int min = Math.min(root.data, Math.min(leftinfo.min, righInfo.min));
        int max = Math.max(root.data, Math.max(leftinfo.max, righInfo.max));

        if(root.data <= leftinfo.max || root.data >= righInfo.min) {
            return new Info(false, size, min, max);
        }

        if(leftinfo.isBST && righInfo.isBST) {
            maxBST = Math.max(maxBST, size);
           return  new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }


    public static Node MergeBST(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        int i=0, j=0;
        ArrayList<Integer> FinalList = new ArrayList<>();
        while (i<arr1.size() && j<arr2.size()) {
            if( arr1.get(i) <= arr2.get(i)) {
                FinalList.add(arr1.get(i));
                i++;
            } else {
                FinalList.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            FinalList.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            FinalList.add(arr2.get(j));
            j++;
        }
        
        return BalancedBST(FinalList, 0, FinalList.size()-1);
    }

    public static Node BalancedBST(ArrayList<Integer> inorder,int si, int ei) {
        if(si>ei) {
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(inorder.get(mid));
        root.left = BalancedBST(inorder, si, mid-1);
       root.right = BalancedBST(inorder, mid+1, ei);
       
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left= new Node(45);
        root.right.right= new Node(70);
        root.right.right.left= new Node(65);
        root.right.right.right = new Node(80);

        Info info = largstbst(root);
        System.out.println("largest bst "+ maxBST);
    }
    }
