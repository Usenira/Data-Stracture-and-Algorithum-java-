package code.Nira.BinaryTress;

import java.util.ArrayList;

public class LCAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data; 
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }
        path.add(root);
        if(root.data  == n) {
            return true;
        }
        boolean Foundleft = getPath(root.left, n, path);
        boolean Foundright = getPath(root.right, n, path);
        if(Foundleft || Foundright) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2  = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        //last common ancenster
        int i=0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        if(rightlca == null) {
            return leftlca;
        }
        if(leftlca == null) {
            return rightlca;
        }
        return root;
    }

        public static int lcaDist(Node root, int n) {
            if(root == null) {
                return -1;
            }
            if(root.data == n) {
                return 0;
            }
            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);
        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist+1;
        } else {
            return leftDist+1;
        }
    }

       public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dits1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dits1+dist2;
    }
public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    int n1 = 4, n2 = 7;
    System.out.println(minDist(root, n1, n2));
}
}
