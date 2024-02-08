package LINKEDLIST;

public class ReverseLL {

    ListNode head;
    ListNode tail;
    int size;
    
    public ReverseLL(int size) {
        this.size = size;
    }

    public class ListNode {
        
        int val;
        ListNode next;

        public ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;

        }
    }
    public static void main(String[] args) {
        
    }

    // https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseNode(ListNode head) {
        if(size < 2) {
            return head;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            next = next.next;
        }
        
        return prev;
    }

    public ListNode reverseInBetween(ListNode node, int left, int right) {

        if(left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        //skip left - 1 node 
        for(int i=0; current != null && i<left-1; i++) {
            prev = current;
            current = current.next;
        } 

        ListNode last = prev;
        ListNode newEnd  = current;

        ListNode next = current.next;
        for(int i=0; current != null && i<left-right+1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null) {
            next = next.next;
            }
        }

        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

         newEnd.next = current;
         return head;//head is an intenal process of lettcode ok yeah alright!
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);

        ListNode secondHead = reverseNode(mid);
        ListNode rereverseHead = secondHead;
        
        while (head != null && secondHead != null) {
            if(head.val != secondHead.val) {
                break;
            }
                head = head.next;
                secondHead = secondHead.next;
            }
               reverseNode(rereverseHead);
            
               if(head == null || secondHead == null) {
                return true;
               }
               return false;
    }

    public ListNode middleNode(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reOrderList(ListNode node) {
        if(head == null || head.next == null) {
            return null; 
    }

    ListNode mid = middleNode(node);
    ListNode headFast = head;
    ListNode headSecond = reverseNode(mid);

    while (headFast != null && headSecond != null) {
        ListNode temp = headFast.next;
        headFast.next = headSecond;
        headFast = temp;
        temp = headSecond.next;
        headSecond.next = headFast;
        headSecond = temp;
    }
    if(headFast != null) {
        headFast.next = null;
    }
}

// https://leetcode.com/problems/reverse-nodes-in-k-group/

   public ListNode reverseKGroup(ListNode head, int k) {
    if(k <= 1 || head == null) {
        return head;
    }

    ListNode prev = null;
    ListNode current = head;
   while (current != null) {
    
    ListNode last = prev;
    ListNode newEnd = current;

    ListNode next = current.next;
    for(int i=0; current != null && i<k; i++) {
        current.next = prev;
        prev = current;
        current = next;
        if(next != null) {
            next = next.next;
        }
        if(current == null || current.next == null) {
            break;
        }
    } 

    if(last != null) {
        last.next = prev;
    } else {
        head = prev;
    }

    newEnd.next = current;
   }

   //skip the k nodes
   for(int i=0; i<k; i++) {
    prev = current;
    current = current.next;
   }
}
   return head;
}


    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        //1. count group
        int group_count = 0;
        ListNode temp_head = head;
        while(temp_head != null){
            group_count++;
            temp_head = temp_head.next;
        }
        group_count /= k;

        //2. Reverse each group
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while(group_count-- > 0){
            ListNode temp_tail = head;
            int i = k;
            ListNode prev = null, curr = head, next = head.next;
            // reverse
            while(i-- > 0){
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next != null) next = next.next;
            }
            tail.next = prev;
            tail = temp_tail;
            head = curr;
        }
        if(head != null) tail.next = head;
        return result.next;
        
}

public ListNode reverseAltrKGroup(ListNode head, int k) {

ListNode last = head;
int length = 0;
while (last.next != null) {
    last = last.next;
    length++;
}
last.next = head;
int reverse = k%length;
int skip = length - reverse;
 ListNode newLast = head;
for(int i=0; i<skip; i++) {
    newLast = newLast.next;
}
head = newLast.next;
newLast.next = null;
return head;
}
