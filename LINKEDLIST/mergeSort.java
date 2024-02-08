package LINKEDLIST;

public class mergeSort {
    private ListNode head;
    private ListNode prev;
    private ListNode tail;
    private int size;

    public mergeSort(){
        this.size = 0;
    }
    
    public static void main(String[] args) {
         mergeSort list = new mergeSort();

         mergeSort first = new mergeSort();
         mergeSort second = new mergeSort();

         list.insertLast(1);
         list.insertLast(3);
         list.insertLast(5);


         list.insertLast(1);
         list.insertLast(2);
         list.insertLast(9);
         list.insertLast(14);
        //  mergeSort ans = mergeSort.merge(first, second);// mergesort print
        //  ans.display();

         list.display();
         list.bubbleSort();
         list.display();
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //merge
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    //merging two list
    ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (left != null && right != null) {
            if(left.val < right.val) {
                tail.next = left;
                left = left.next;
                tail = tail.next;
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
        while (left != null) {
                tail.next = left;
                left = left.next;
                tail = tail.next;
        }
        while (right != null) {
            tail.next = right;
            right = right.next;
            tail = tail.next;
        }
        return dummyHead;
    }

     //ADD EVERY newNODE AT THE FIRST AHEAD OF HEAD
     public void insertFirst(int val) {
        ListNode node = new ListNode(val);
         node.next = head;
          head = node;

          if(tail == null) {
            tail = head;
          }
          size += 1;
    }

    //ADD EVERY newNODE AT THE LAST AFTER THE TAIL
    public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
            return;
        }
        ListNode node = new ListNode(val);
           tail.next = node;
           tail = node; 
           size += 1;
    }

    //finding middle of the list
    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
           midPrev = (midPrev == null) ? head : midPrev.next;
           head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    //same upper function like it gives middle Node of list
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //get function
    public ListNode get(int index) {
        ListNode node = head;
        for(int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }

    public void bubbleSort() {
        bubbleSort(size-1, 0);
    }

    public void bubbleSort(int row, int col) {
        if(row == 0) {
            return;
        }

        if(col < row) {
            ListNode first = get(col);
            ListNode second = get(col+1);

            if(first.val < second.val) {
                //swap
                //first swapping condition
                if(first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }

                //second swapping condition
                else if(second == tail) {
                    ListNode prev = get(col-1);
                    first.next = null;
                    tail = first;
                    prev.next = second;
                    second.next = tail;
                } else {
                    ListNode prev = get(col-1);
                    first.next = second.next;
                    second.next = first;
                    prev.next = second;
                }
            }
            bubbleSort(row, col+1);
        } else {
            bubbleSort(row-1, 0);
        }
    }

    //Reverse a linkedList
    public void Reverse(ListNode node) {
        if(node == tail) {
            head = tail;
            return;
        }

        Reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //Reverse a linkedList using in - place method
    public ListNode reverseLL(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
        present.next = prev;
        prev = present;
        present = next;
        if(next != null ) {
        next = next.next;
        }
    }
   return prev;
    }

    //Reverse linkedlist in-between index Q:92//
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
        return head;
        }

        //skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for(int i=0; current != null && i<left-1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;

        //reverse between left and right
        ListNode next = current.next;
        for(int i=0; i<right-left+1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            next = (next != null) ? next.next : null;
        }
        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }


    // https://leetcode.com/problems/palindrome-linked-list/ Q:234
     public boolean isPalindrome(ListNode head) {
        
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseLL(mid);
        ListNode rereverseHead = headSecond;
        
        //compare both halves
        while (head != null && headSecond != null) {
            if(head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
       reverseLL(rereverseHead);
        return head == null || headSecond == null;
    }

    // https://leetcode.com/problems/reorder-list/description/ Q:143
   
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode hs = reverseLL(mid);
        ListNode hf = head;

        //Rearrange
        while (hf != null && hs != null) {
        ListNode temp = hf.next;
        hf.next = hs;
        hf = temp;

        temp = hs.next;
        hs.next =hf;
        hs = temp;
        }

        //next of tail to null
        if(hf != null) {
            hf.next = null;
        }
    }

    // https://leetcode.com/problems/reverse-nodes-in-k-group/
    //its also reversing the < k end items -> modify it accordingly
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) {
            return head;
        }

        //skip the first left-1 nodes
        ListNode current = prev;
        ListNode prev = null;

        while (true) {

        ListNode last = prev;
        ListNode newEnd = current;

        //reverse between left and right
        ListNode next = current.next;
        for(int i=0; current != null &&  i<k; i++) {
            current.next = prev;
            prev = current;
            current = next;
            next = (next != null) ? next.next : null;
        }
        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        if(current == null) {
            break;
        }
        prev = newEnd;
    }
        return head;
    
    }

    public ListNode reverseAltKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) {
            return head;
        }

        //skip the first left-1 nodes
        ListNode current = prev;
        ListNode prev = null;

        while (current != null) {

        ListNode last = prev;
        ListNode newEnd = current;

        //reverse between left and right
        ListNode next = current.next;
        for(int i=0; current != null &&  i<k; i++) {
            current.next = prev;
            prev = current;
            current = next;
            next = (next != null) ? next.next : null;
        }
        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        //skip the k nodes
        for(int i=0; current != null && i<k; i++) {
            prev = current;
            current = current.next;
        }
    }
        return head;
    }

    // https://leetcode.com/problems/rotate-list/ Q: 61
     public ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;
        int rotation = k % length;
        ListNode newLast = head;


        int skip = length - rotation;
        for(int i=0; i < skip - 1; i++) {
            newLast = newLast.next;
        }

            head = newLast.next;
            newLast.next = null;
            return head;
    }

    public class ListNode {
          int val;
          ListNode next;

          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    }

