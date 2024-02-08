package LINKEDLIST;


public class LL {

    public static void main(String[] args) {
        
        LL list = new LL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(8);
        list.insertFirst(98);
        list.insertrec(62, 2);
        list.display();

    
        }

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    //ADD EVERY newNODE AT THE FIRST AHEAD OF HEAD
    public void insertFirst(int val) {
        Node node = new Node(val);
         node.next = head;
          head = node;

          if(tail == null) {
            tail = head;
          }
          size += 1;
    }

    //ADD AT ANY PATICULAR INDEX
    public void insertMiddle(int val ,int index) {
        if(index == 0) {
            insertFirst(val);
            return;
        }

        if(index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i=1; i<index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    //ADD EVERY newNODE AT THE LAST AFTER THE TAIL
    public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
           tail.next = node;
           tail = node; 
           size += 1;
    }

    //DELETE FIRST NODE FROM THE LINKEDLIST
    public int DeleteFirst() {
        int val = head.value;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return val;
    }


    //DELETE LAST NODE FROM LINKEDLIST
    public int deleteLast() {
        if(size <= 1){
            return DeleteFirst();
        } 
        
        Node SecondLast = get(size-2);
        int val  = tail.value;
        tail = SecondLast;
        tail.next = null;
        size--;
        return val;
    }


    //this gives second last index Node of the linkedlist
    public Node get(int index){
        Node node = head;
        for(int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }

    //DELETE A PARTICULAR INDEX NODE FROM LINKEDLIST
    public int middleIndex(int index) {
        if(index == 0) {
            return DeleteFirst();
        }
        if(index == size-1) {
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }


    //FIND NODE FROM LINKEDLIST ON BASIS OF VALUE
    public Node find(int value) {
        Node node  = head;
        while (node != null) {
           if(node.value == value) {
            return node;
            }
            node = node.next;
        }
        return null;
    } 
    //THIS METHOD DISPLAY
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    //insert using recursion
    public void insertrec (int val, int index) {
        if(head != null) {
        head = insertrec(val, 3, head);
        return;
    } 
}

    private Node insertrec(int val, int index, Node node) {
        if(index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertrec(val, index-1, node.next);
        return node;
    }

private class Node {
    private int value;
    private Node next;

    public  Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
}
