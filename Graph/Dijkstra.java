package code.Nira.Graph;

import java.util.*;
public class Dijkstra {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void CreateGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        
    }

    static class pair implements Comparable<pair> {
        int n;
        int path;

        pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(pair p2) {
            return this.path - p2.path;
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dista[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dista[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src, 0));

        while (!pq.isEmpty()) {
            pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;

                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dista[u]+wt < dista[v]) {
                        dista[v] = dista[u] + wt;
                        pq.add(new pair(v, dista[v]));
                    }
                }
            }
        }
        for(int i=0; i<dista.length; i++) {
            System.out.print(dista[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int v =6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);

        int src =0;
        dijkstra(graph, src);
    }
}
