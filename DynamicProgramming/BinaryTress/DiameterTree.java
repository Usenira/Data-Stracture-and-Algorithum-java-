package code.Nira.BinaryTress;

public class DiameterTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int heights(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = heights(root.left);
        int rh = heights(root.right);
        return Math.max(lh, rh)+1;
    }


    public static int Diameter(Node root) {
        if(root == null) {
            return 0;
        }

        int leftDiameter = Diameter(root.left);
        int rightDiameter = Diameter(root.right);
        int lh = heights(root.left);
        int rh = heights(root.right);
        int SelfDiameter = lh+rh+1;
        return Math.max(SelfDiameter, Math.max(rightDiameter, leftDiameter));
    }
    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info Diameter2(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = Diameter2(root.left);
        Info rightInfo = Diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }
    public static void main(String[] args) {
    Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(Diameter2(root).diam);
}    
}
