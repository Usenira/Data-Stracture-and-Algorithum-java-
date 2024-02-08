package code.Nira.Graph;
import java.util.*;
public class FloodFill {

    public void helper(int[][] image, int sr, int sc, boolean vis[], int orgcol) {

        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgcol ){
            return; 
        }
       
        image[sc][sr] = orgcol;//color hoo sokta;
        //left
        helper(image, sr ,sc-1, vis, orgcol);

        //right
        helper(image,sr, sc+1, vis, orgcol);
        //up

        helper(image,sr-1, sc, vis, orgcol);
        //down
        helper(image,sr+1,sc, vis, orgcol);
    }

    public int[][] floodfill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }
    public static void main(String[] args) {
        int image[][] =new int [image.length][image[0].length];

    }
}
