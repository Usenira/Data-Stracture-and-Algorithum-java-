package code.Nira.Graph;

import java.util.*;

public class Cyclic {
    static class Edge {
        int src;
        int dist;

        public Edge(int s, int d) {
            this.src = s;
            this.dist = d;

        }
    }
    static void CreateGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));


        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));


        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));


        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtill(graph, vis, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtill(ArrayList<Edge> graph[],boolean vis[], int curr, int par) {
        vis[curr] = true;

        for(int i=0; i<graph.length; i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dist]) {
                if(detectCycleUtill(graph, vis, curr, par)) {
                    return true;
                }
                return true;
            } else if(vis[e.dist] && e.dist != par ) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> []graph = new ArrayList[v];
        CreateGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
