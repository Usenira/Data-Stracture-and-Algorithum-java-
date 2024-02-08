package code.Nira.Graph;
import java.util.*;

import code.Nira.Heap.nRopes;
public class ConnectedEdge {
    static class Edge {
        int src;
        int dist;

        public Edge(int s, int d) {
            this.src = s;
            this.dist = d;
        }
    }
    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                bfsUtill(graph, vis);
            }
        }

    }
    public static void bfsUtill(ArrayList<Edge> graph[], boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
       

        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) {
                System.out.print(curr+ " ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dist);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            dfsUtill(graph, i, vis);
        }
    }

    public static void dfsUtill(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr+" ");
        vis[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dist]) {
                dfsUtill(graph, curr, vis);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
