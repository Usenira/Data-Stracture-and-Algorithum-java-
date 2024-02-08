package BinarySearchTrees;

import java.util.ArrayList;

public class Range {
    
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    } 


    //Print Range
    public static void PrintRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            PrintRange(root.left, k1, k2);
            System.out.print(root.data+ " ");
            PrintRange(root.right, k1, k2);
        } else if(root.data < k1) {
            PrintRange(root.right, k1, k2);
        } else {
            PrintRange(root.left, k1, k2);
        }
    }

    //Root to Leaf paths
    public static void PrintPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }

    public static void PrintRoot2Path(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            PrintPath(path);
        }
        PrintRoot2Path(root.left, path);
        PrintRoot2Path(root.right, path);
        path.remove(path.size()-1);
    }

    //Validate a BST
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        } else if(max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right, root, max); 
    }


    //1
    
 //insert
 public static Node insert(Node root, int val) {
    if(root == null) {
       root = new Node(val);
       return root;
    }
    if(root.data > val) {
        root.left = insert(root.left, val);
    } else if(root.data < val) {
        root.right = insert(root.right, val);
    }
    return root;
}
//Create mirror
public static Node CreateMirror(Node root) {
    if(root == null) {
        return null;
    }
    Node leftMirror = CreateMirror(root.left);
    Node rightMirror = CreateMirror(root.right);
    root.left = leftMirror;
    root.right = rightMirror;
    return root;
}

//Sorted Array to Balanced BST
public static Node CreateBST(int arr[], int st, int end) {
    if(st > end) {
        return null;
    }
    int m = (st+end)/2;
    Node root = new Node(arr[m]);
    root.left = CreateBST(arr, st, m-1);
    root.right = CreateBST(arr, m+1, end);
    return root;
}

//Largest BST
static class Info {
    boolean isBST;
    int size;
    int max;
    int min;

    public Info(boolean isBST, int size, int max, int min) {
        this.isBST = isBST;
        this.size = size;
        this.max = max;
        this.min = min;
    }
}

public static

    //inOrder
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int val[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i = 0; i < val.length; i++) {
            root = insert(root,val[i]);
        } 

        inOrder(root);
        System.out.println();

        if(isValidBST(root, null, null)){
            System.out.print("valid");
        } else {
            System.out.print("not Valid");
        }
    }
}
