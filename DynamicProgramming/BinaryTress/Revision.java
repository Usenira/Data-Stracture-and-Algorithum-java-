package code.Nira.BinaryTress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Revision {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void Levelorder(Node root) {
        if(root == null) {
            return;
        }
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currnode =  q.remove();
            if(currnode == null) {
                if(q.isEmpty()) {
                   break;
                } else {
                    q.add(null);
                }
            } else {
                    System.out.println(root.data+" ");
                    if(currnode.left != null) {
                        q.add(currnode.left);
                    }
                    if(currnode.right != null) {
                        q.add(currnode.right);
                    }
                }
            }
        }

        public static int heights(Node root) {
            if(root == null ) {
                return 0;
            }
           int lh = heights(root.left);
           int rh = heights(root.right);
           return Math.max(lh, rh) +1;
        }

        public static int Count(Node root) {
            if(root == null) {
                return 0;
            }
            int lc = Count(root.left);
            int rc = Count(root.right);
            return lc+rc+1;
        }

        public static int Sum(Node root) {
            if(root == null) {
                return 0;
            }
            int lc = Count(root.left);
            int rc = Count(root.right);
            return lc+rc+root.data;
        }

        public static int Diameters(Node root) {
            if(root == null) {
                return 0;
            }
            int leftDiam = Diameters(root.left);
            int rightDiam = Diameters(root.right);
            int lh = heights(root.left);
            int rh = heights(root.right);
            int SelfDiameter = lh+rh+1;
            return Math.max(Math.max(rightDiam, leftDiam), SelfDiameter);
        }

        static class Infos {
            int diam;
            int ht;
    
            public Infos(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }
            public static Infos diameteroo(Node root) {
                if(root == null) {
                    return new Infos(0, 0);
                }
                Infos leftDiam = diameteroo(root.left);
                Infos richDiam = diameteroo(root.right);
                int diam = Math.max(Math.max(leftDiam.diam, richDiam.diam), leftDiam.ht+richDiam.ht+1);
                int ht = Math.max(leftDiam.ht , richDiam.ht) +1;
                return new Infos(diam, ht);
        }

    
        public static boolean CheckIdentical(Node root, Node Subtree) {
            if(root == null) {
                return false;
            }
            if(root.data == Subtree.data ) {
                if(isIdentical(root, Subtree)) {
                    return true;
                }
            }
            return CheckIdentical(root.left, Subtree) || CheckIdentical(root.right, Subtree);
        }

        public static boolean isIdentical(Node root, Node Subtree) {
            if(root == null && Subtree == null) {
                return true;
            } else if(root == null || Subtree == null || root.data != Subtree.data) {
                return false;
            }
            if(!isIdentical(root.left, Subtree.left)) {
                return false;
            }       
            if(!isIdentical(root.right, Subtree.right)) {
                return false;
            }
            return true;
        }
        static class Icon {
            Node node;
            int hd;

            public Icon(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        public static void TopAngleview(Node root) {
            Queue<Icon> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int max = 0, min = 0;
            q.add(new Icon(root, 0));
            q.add(null);
            while (!q.isEmpty()) {
                Icon currnode = q.remove();
                if(currnode == null) {
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if(!map.containsKey(currnode.hd)) {
                        map.put(currnode.hd, currnode.node);
                    }
                    if(currnode.node.left != null) {
                        q.add(new Icon(currnode.node.left, currnode.hd-1));
                        min = Math.min(min, currnode.hd-1);
                    }
                    if(currnode.node.right != null) {
                        q.add(new Icon(currnode.node.right, currnode.hd+1));
                        max = Math.max(max, currnode.hd+1);
                    }
                }
            }
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }

        public static void KLevel(Node root, int k, int level) {
            if(root == null) {
                return;
            }
            if(level == k ) {
                System.out.println(root.data + " ");
                return;
            }
            KLevel(root.left, k, level+1 );
            KLevel(root.right, k, level+1 );
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if(root == null) {
                return false;
            }
            path.add(root);
            if(root.data == n) {
                return true;
            }
            boolean findLeft = getPath(root.left, n, path);
            boolean findRight = getPath(root.right, n, path);

            if(findLeft || findRight) {
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

            int i = 0;
            for (; i< path1.size() && i< path2.size(); i++) {
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
            Node leftNode = lca2(root.left, n1, n2);
            Node rightNode = lca2(root.right, n1, n2);

            if(leftNode == null) {
                return rightNode;
            }
            if(rightNode == null) {
                return leftNode;
            }
            return root;
        }

        public static int KthAncestor(Node root, int n, int k) {
            if(root == null) {
                return -1;
            }
            if(root.data == n) {
                return 0;
            }
           int leftDist =  KthAncestor(root.left, n, k);
           int rightDist = KthAncestor(root.right, n, k);
           if(leftDist == -1 && rightDist == -1) {
            return -1;
           } 
           int max = Math.max(leftDist, rightDist);
           if(max+1 == k) {
        System.out.println(root.data);
           }
           return max+1;
                }

                public static int minDist(Node root, int n) {
                    if(root == null) {
                        return -1;
                    }
                    if(root.data == n) {
                        return 0;
                    }
                   int leftdist = minDist(root.left, n);
                   int rightdist = minDist(root.right, n);
                   
                   if(leftdist == -1 && rightdist == -1) {
                    return -1;
                   }
                  else if(leftdist == -1) {
                    return rightdist+1;
                   } else  {
                   return leftdist+1;
                   }
                }
                public static int minnidist(Node root, int n1, int n2) {
                   Node lca = lca2(root, n1, n2);
                   int dist1c = minDist(lca, n1);
                   int dist2 = minDist(lca, n2);
                   return dist1c+dist2;
                }

                public static int Transform(Node root) {
                    if(root == null) {
                        return 0;
                    }
                    int leftChild = Transform(root.left);
                    int rightChild = Transform(root.right);
                     int data = root.data;
                     int newleft = root.left == null ? 0 : root.left.data;
                     int newright = root.right == null ? 0 : root.right.data;
                     root.data = newleft + leftChild + newright + rightChild;
                     return data;
                }
                public static void preOrder(Node root) {
                    if(root == null) {
                        return ;
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

    // Node subroot = new Node(2);
    // subroot.left = new Node(4);
    // subroot.right = new Node(5);
Transform(root);
preOrder(root);
}
}
