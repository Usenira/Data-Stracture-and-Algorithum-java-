package Stacks;

import java.util.*;
public class LargestAreaHistogram {

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
    System.out.println(LargestReactangleArea(heights));
    }

    public static int LargestReactangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int max =0 ;
    stack.push(0);

    for (int i = 1; i < heights.length; i++) {
        while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
            max = getMax(heights, stack, max, i);
        }
            stack.push(i); 
        }
        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        
    }
    return max;
    }

    private static int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
        int area;
        int pooped = stack.pop();
        if(stack.isEmpty()) {
            area = arr[pooped] * i;
        } else {
            area = arr[pooped] * (i-1-stack.peek());
        }
        return Math.max(max, area);
    }
}
