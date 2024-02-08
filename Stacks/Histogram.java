package code.Nira.Stacks;

import java.util.Stack;

public class Histogram {
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(maxArea(heights));
        
    }
    public static int maxArea(int heights[]) {
        int MaxArea = 0;
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];

        //next smaller right
        Stack<Integer> s1 = new Stack<>();
        for (int i =heights.length-1; i >= 0; i--) {
            while (!s1.isEmpty() && heights[i] <= heights[s1.peek()]) {
                s1.pop();
            }
            if(s1.isEmpty()) {
                nsr[i] = heights.length; 
            } else {
                nsr[i] = s1.peek();
            }
            s1.push(i);
        }
        //next smaller left
        Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!s2.isEmpty() && heights[i] <= heights[s2.peek()]) {
                s2.pop();
            }
            if(s2.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s2.peek();
            }
            s2.push(i);
        }

        //find area of largest histgram
        
        for (int i = 0; i < heights.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int currArea = heights[i] * width; 
            MaxArea = Math.max(MaxArea, currArea);
        }
       return MaxArea;
    }


}
