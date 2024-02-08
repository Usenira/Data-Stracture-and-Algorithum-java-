package Stacks;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class stack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(5);
        stk.push(78);
        stk.push(98);

       System.out.println(stk.pop());

       Queue<Integer> queue = new LinkedList<>();

       queue.add(34);
       queue.add(76);
       queue.add(85);
       queue.add(45);

       System.out.println(queue.remove());

       Deque<Integer> deque = new ArrayDeque<>();
       deque.add(87);
       deque.addLast(70);
       deque.addFirst(65);
    }
}
