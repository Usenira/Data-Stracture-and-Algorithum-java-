package BinarySearchTrees;

public class DeleteNode {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    } 

    public static Node Delete(Node root, int val) {
        if(root.data < val) {
            root.right = Delete(root.right, val);
        } else if(root.data > val) {
            root.left = Delete(root.left, val);
        } else {
            //volia 
            //case : delete Leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            //case : Single Child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            //case : Both Child
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = Delete(root.right, IS.data);

        }
        return root;
    }
    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;

        }
        return root;
    }

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

    //inOrder
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
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
        root = Delete(root, 10);
        
        inOrder(root);
    }
}
