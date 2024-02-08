package LINKEDLIST;

public class insertRec {

    private Node head;
    private Node tail;
    private int size;
    public insertRec() {
        this.size = 0;
    }
    public static void main(String[] args) {
        insertRec list = new insertRec();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(8);
        list.insertrec(67, 3);
        list.display();


    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
         node.next = head;
          head = node;

          if(tail == null) {
            tail = head;
          }
          size += 1;
    }


    public void insertrec (int val, int index) {
        head = insertrec(val, 3, head);
    }

    private Node insertrec(int val, int index, Node node) {
        if(index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertrec(val, index--, node.next);
        return node;
    }

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val,Node next) {
            this.val = val;
            this.next = next;
        }

      
    }
}