package code.Nira.GreddyAlgorithum;

import java.util.*;

public class Revision {

    public static void main(String[] args) {
      Integer costHer[] = {4,1,2};
      Integer costVert[] = {2,1,3,1,4};
      
      Arrays.sort(costHer, Collections.reverseOrder());
      Arrays.sort(costVert, Collections.reverseOrder());
      
      int v = 0, h = 0;
      int hp =1, vp =1;
      int cost=0;
      while (v< costVert.length && h< costHer.length) {
        if(costVert[v] >= costHer[h]) {
          cost += costVert[v]*hp;
          vp++;
          v++;
        } else {
          cost += costHer[h]*vp;
          hp++;
          h++;
        }
      }
      while (v<costVert.length) {
        cost += costVert[v]*hp;
        vp++;
        v++;
      }
      while (h<costHer.length) {
        cost += costHer[h]*vp;
        hp++;
        h++;
      }
      System.out.println("min cost of cuts = " + cost);
    }
  }