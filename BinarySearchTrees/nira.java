package code.Nira.BinarySearchTrees;

import java.util.ArrayList;

public class nira {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
         root = new Node(val);
         return root;
        }
        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if(root.data < val ) {
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            root.left = delete(root.left, val);
        } else {
            if(root.left == null && root.right == null ) {
                return null;
            }
        
        if(root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        Node IS = findInorderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root, IS.data);
    }
    return root;
}

public static Node findInorderSuccessor(Node root) {
    while(root.left != null) {
        root = root.left;
    }
    return root;
}

public static void PrintRange(Node root, int k1, int k2) {
    if(root == null) {
        return;
    }
    if(root.data >= k1 && root.data <= k2) {
        PrintRange(root.left, k1, k2);
        System.out.print(root.data+" ");
        PrintRange(root.right, k1, k2);
    } else if(root.data < k1) {
        PrintRange(root.left, k1, k2);
    } else {
        PrintRange(root.right, k1, k2);
    }
}

public static void  Printroot2Leaf(Node root, ArrayList<Integer>path) {
    if(root == null) {
        return;
    }
    path.add(root.data);
    if(root.left == null && root.right == null) {
        Printpath(path);
    }
    Printroot2Leaf(root.left, path);
    Printroot2Leaf(root.right, path);
    path.remove(path.size()-1);
}

public static void Printpath(ArrayList<Integer>path) {
    for (int i = 0; i < path.size(); i++) {
        System.out.print(path.get(i));
    }
    System.out.println();
}

public static boolean isValid(Node root, Node min, Node max) {
if(root == null) {
    return true;
}

if(min != null && root.data <= min.data) {
    return false;
} else if(max != null && root.data >= max.data) {
    return false;
}
return isValid(root.left, min, root) && isValid(root.right, root, max);

}

public static Node Mirror(Node root) {
    if(root == null) {
        return null;
    }
    Node leftMirror = Mirror(root.left);
    Node RightMirror = Mirror(root.right);
     root.left = leftMirror;
     root.right = RightMirror;
     return root;
}

public static Node BalancedBST(int arr[],int si, int ei) {
    if(si>ei) {
        return null;
    }
    int mid = (si+ei)/2;
    Node root = new Node(arr[mid]);
    root.left = BalancedBST(arr, si, mid-1);
   root.right = BalancedBST(arr, mid+1, ei);
   
    return root;
}

public static void preorder(Node root) {
    if(root == null) {
        return;
    }
    System.out.println(root.data+" ");
    preorder(root.left);
    preorder(root.right);
}
    public static void main(String[] args) {
        // int values[] = {10,7,5,4,3,6,2,8,9,1};
        // Node root = null;
        // for (int i = 0; i < values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();

        // root = delete(root, 6);
        // System.out.println();
        // inorder(root);

        // PrintRange(root, 5, 9);
        // Printroot2Leaf(root, new ArrayList<>());
        int arr[] = {3,5,6,8,10,11,12};
    Node root = BalancedBST(arr, 0, arr.length-1);
    preorder(root);
        }
}
