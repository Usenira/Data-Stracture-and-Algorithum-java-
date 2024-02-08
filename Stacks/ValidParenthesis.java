package code.Nira.Stacks;
import java.util.*;
public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "{{}}}";
        System.out.println(minAddToMakeValid(s));
        
    }

    // public static boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<>();

    //     for (char ch : s.toCharArray()) {
    //         if(ch == '(' || ch == '{' || ch == '[') {
    //             stack.push(ch);
    //         }
    //         else {
    //             if(ch == ')') {
    //                 if( stack.isEmpty() || stack.pop() != '(') {
    //                     return false;
    //                 }
    //             }
    //             if(ch == '}') {
    //                 if( stack.isEmpty() || stack.pop() != '{') {
    //                     return false;
    //                 }
    //             }
    //             if(ch == ']') {
    //                 if( stack.isEmpty() || stack.pop() != '[' ) {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
    
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        // String open = "{";
        // String close = "}";

        for (char ch : s.toCharArray()) {
            if(ch == '}') {
                if(!stack.isEmpty() && stack.peek() == '}') {
                    stack.pop();
                    if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
}
}
