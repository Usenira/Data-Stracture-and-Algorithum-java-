package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HeightTree {
    static class Node {
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        //lh = left Height , rh = right Height
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }

    //Count Of Nodes
    public static int countNode(Node root) {
        if(root == null) {
            return 0;
        }
        int leftCount = countNode(root.left);
        int rightCount = countNode(root.right);
        return leftCount+rightCount+1;
    }

    //Sum of Nodes
    public static int SumNode(Node root) {
        if(root == null) {
            return 0;
        }
        return SumNode(root.left)+SumNode(root.right)+root.data;
    }

    //Daimeter Of Node
    //TIME COMPLEXITY : O(N2);
    //WORST TIME COMPLEXITY.
    public static int Daimeter(Node root) {
        if(root == null) {
            return 0;
        }
        int ldm = Daimeter(root.left);
        int lh = height(root.left);
        int rh = height(root.right);
        int rdm = Daimeter(root.right);
        int selfDm = lh+rh+1;
        return Math.max(Math.max(rdm, ldm),selfDm); 
    }

    //APPROACH : 2
    //TIME COMPLEXITY : O(N) BEST TC
    public static class Info {
        int diam,ht;
        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

        public static Info dInfo(Node root) {
            if(root == null) {
                return new Info(0, 0);
            }

            int diam = Math.max(Math.max(dInfo(root.left).diam, dInfo(root.right).diam), dInfo(root.left).ht + dInfo(root.right).ht + 1);
            int ht = dInfo(root.left).ht + dInfo(root.right).ht + 1;
            return new Info(diam, ht);
        }

        //SUBTREE OF A ANOTHER TREE
        public static boolean isSubtree(Node root, Node subroot) {
            if(root == null) {
                return false;
            }
            if(root.data == subroot.data) {
                if(isIdentical(root, subroot)) {
                    return true;
                }
            }
            return isSubtree(root.left, subroot) || isIdentical(root.right, subroot);
        }
        
        public static boolean isIdentical(Node root, Node subroot) {
            if(root == null && subroot == null) {
                return true;
            } else if(root == null || subroot == null || root.data != subroot.data) {
                return false;
            }

            if(!isIdentical(root.left, subroot.left)) {
                return false;
            }
            if(!isIdentical(root.right, subroot.right)) {
                return false;
            }
            return true;
        }

        public static class  Nodes {
            Node node;
            int hd;
            public Nodes(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        //TOP VIEW OF TREE
        public static void topview(Node root) {

            //level order
            Queue<Nodes> q = new LinkedList<>();
            HashMap<Integer,Node> map = new HashMap<>();

            int max = 0, min = 0;
            q.add(new Nodes(root, 0));
            q.add(null);
            while (!q.isEmpty()) {
                Nodes curr = q.remove();
                if(curr == null) {
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null) {
                    q.add(new Nodes(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null) {
                    q.add(new Nodes(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
            }
            for(int i = min; i<=max; i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }

        //Kth Level 
        public static void kLevel(Node root, int level, int k) {
            if(root == null) {
                return;
            }
            if(level == k) {
                System.out.print(root.data + " ");
                return;
            }
            kLevel(root.left, level+1, k);
            kLevel(root.right , level+1, k);
        }


        //Lowest common Ancestor

        public static boolean getPath(Node root, int n, ArrayList<Node>path) {
            if(root == null) {
                return false;
            }
            path.add(root);
            if(root.data == n) {
                return true;
            }
            boolean foundleft = getPath(root.left, n, path);
            boolean foundright = getPath(root.right, n, path);
            if(foundleft || foundright) {
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }
        public static Node lca(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);
            
            //last common ancester
            int i=0;
            for(; i<path1.size() && i<path2.size(); i++) {
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            //last equal node -> i-1 th place
            Node lca = path1.get(i-1);
            return lca;
        }

        //Approch -2 find Lowest common ancester
        public static Node lca2(Node root, int n1, int n2) {
            if(root == null || root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            //leftLca = val rightLca = null
            if(leftLca == null) {
                return rightLca;
            }
            if(rightLca == null) {
                return leftLca;
            }
            return root;
        }

        //Minimum Distance between two Nodes
        public static int lcaDist(Node root, int n) {
            if(root == null) {
                return -1;
            }
            if(root.data == n) {
                return 0;
            }
            int leftdist = lcaDist(root.left, n);
            int rightdist = lcaDist(root.right, n);

            if(leftdist == -1 && rightdist == -1) {
                return -1;
            } else if(leftdist == -1) {
                return rightdist+1;
            } else {
                return leftdist+1;
            }
        }

        public static int MinDist(Node root, int n1, int n2) {
            Node lca = lca2(root, n1, n2);
            int dist1 = lcaDist(lca, n1);
            int dist2 = lcaDist(lca, n2);
            return dist1 + dist2;
        }

        //Kth Ancester 
        public static int KthAncester(Node root, int n, int k) {
            if(root == null) {
                return -1;
            }
            if(root.data == n) {
                return 0;
            }

            int leftDist = KthAncester(root.left, n, k);
            int rightDist = KthAncester(root.right, n, k);

            if(leftDist == -1 && rightDist ==-1) {
                return -1;
            }

            int max = Math.max(leftDist, rightDist);
            if(max+1 == k) {
                System.out.println("kth node = " + root.data);
            }
            return max+1;
        }

        //Transform to sum Tree
        public static int Trasform(Node root) {
            if(root == null ) {
                return 0;
            }
            int leftChild = Trasform(root.left);
            int rightChild = Trasform(root.right);
            int data = root.data;
            int newleft = root.left == null ? 0 : root.left.data;
            int newright = root.right == null ? 0 : root.right.data;
            root.data = leftChild + newleft + rightChild + newright;
            return data;
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        Trasform(root);
        preOrder(root);
    }
}
