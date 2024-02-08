package BackTracking;
//BackTracking: you are making some changes whilegoing below recursion calls when you go out from that
//  recursion calls the changes thats are made by those recursion calls  shouldn't be avilable.

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {

    public static void main(String[] args) {
        // // System.out.println(maze(3, 3));
        // ArrayList<String> list = MazePath("", 3, 3);
        // System.out.println(list);

        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true}};

            
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0, 0,path,1);
    }
    // static int maze(int r, int c) {
    //     if(r == 1 || c == 1) {
    //         return 1;
    //     }
    //     int left = maze(r-1, c);
    //     int right = maze(r, c-1);
    //     return left + right;
        
    // }

    // static ArrayList<String> MazePath(String p, int r, int c) {
    //     if(r == 1 && c == 1) {
    //         ArrayList<String> list = new ArrayList<>();
    //         list.add(p);

    //         return list;
    //     }

    //     ArrayList<String> list = new ArrayList<>();
    //     if(r>1) {
    //     list.addAll(MazePath(p+'V', r-1, c));
    //     } 
    //     if(r>1 && c>1) {
    //         list.addAll(MazePath(p+'D', r-1, c-1));
    //     }
    //     if(c>1){
    //    list.addAll( MazePath(p+'H', r, c-1));
    //     }
    //     return list;
    // }

    // //path Restrictions in the maze
    // static void PathRestrations(String p, boolean[][] maze, int r, int c) {
    //     //if maze is false then path is blocked or have some restriction.
    //     //if maze is true then u can goo.
        
    //     if(r == maze.length-1 && c == maze[0].length-1) {
    //         System.out.println(p);
    //         return;
    //     }

    //     if(!maze[r][c]) {
    //         return;
    //     }
    //     if(r < maze.length-1) {
    //         PathRestrations(p+'D', maze, r+1, c);
    //     } 
    //     if(c < maze[0].length-1){
    //         PathRestrations(p+'R', maze, r, c+1);

    //     }
    // }

    // backTracking condition occuer when the recursion call don't hits the base condition and runs for infinite function call

    // static void allPath(String p, boolean[][] maze, int r, int c) {
        
    //     if(r == maze.length-1 && c == maze[0].length-1) {
    //         System.out.println(p);
    //         return;
    //     }

    //     if(!maze[r][c]) {
    //         return;
    //     }

    //     //i am considering this block in my path
    //     maze[r][c] = false;

    //     //path for Down
    //     if(r < maze.length-1) {
    //         allPath(p+'D', maze, r+1, c);
    //     } 
    //     //Right
    //     if(c < maze[0].length-1){
    //         allPath(p+'R', maze, r, c+1);

    //     }
    //     //Upward
    //      if(r > 0){
    //         allPath(p+'U', maze, r-1, c);
    //     }
    //     //left
    //      if(c > 0){
    //         allPath(p+'L', maze, r, c-1);

    //     }

    //     //this line is where the function will be over
    //     //so before the function gets removed, also remove the changes that were made by function.
    //     maze[r][c] = true; 
    // }

    // for print the path to the maze array
    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int steps) {
        
        if(r == maze.length-1 && c == maze[0].length-1) {
            // System.out.println(p); // if you want to print path interms of "DRUL" 
            path[r][c] = steps;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[r][c]) {
            return;
        }

        //i am considering this block in my path
        maze[r][c] = false;
        path[r][c] = steps;

        //path for Down
        if(r < maze.length-1) {
            allPathPrint(p+'D', maze, r+1, c, path, steps+1);
        } 
        //Right
        if(c < maze[0].length-1){
            allPathPrint(p+'R', maze, r, c+1, path, steps+1);

        }
        //Upward
         if(r > 0){
            allPathPrint(p+'U', maze, r-1, c, path, steps+1);
        }
        //left
         if(c > 0){
            allPathPrint(p+'L', maze, r, c-1, path, steps+1);

        }

        //this line is where the function will be over
        //so before the function gets removed, also remove the changes that were made by function.
        maze[r][c] = true; 
        path[r][c] = 0;
    }
}
