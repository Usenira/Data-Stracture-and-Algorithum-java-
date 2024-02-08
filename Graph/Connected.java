package code.Nira.Graph;

import java.util.ArrayList;
import java.util.*;

public class Connected {
    static class Edge {
        int src; 
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void CreateGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void dfs(ArrayList<Edge>[] graph, boolean vis[], int curr) {
        vis[curr] = true;
        System.out.print(curr+" ");

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph,vis, e.dest);
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void Kosaraju(ArrayList<Edge>[] graph, int V) {
        //step 1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        // step2
        //transpose graph
        ArrayList<Edge> traspose[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            vis[i] = false;
            traspose[i] = new ArrayList<Edge>();
        }
        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                traspose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        while (!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                System.out.print("scc ->");
                dfs(traspose, vis, curr);
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        Kosaraju(graph, V);
    }
}
