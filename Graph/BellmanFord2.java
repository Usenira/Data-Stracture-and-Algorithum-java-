package code.Nira.Graph;
import java.util.*;
public class BellmanFord2 {
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

    static void CreateGraph(ArrayList<Edge> graph) {
       
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmenFord(ArrayList<Edge> graph, int src, int V) {
        int dista[] = new int[V];
        for(int i=0; i<dista.length; i++) {
            if(i != src) {
                dista[i] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<V-1; i++) {
            for(int j=0; j<graph.size(); j++) {
                    Edge e = graph.get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dista[u] != Integer.MAX_VALUE && dista[u] + wt < dista[v]) {
                        dista[v] = dista[u]+wt;
                }
            }
        }
        for(int i=0; i<dista.length; i++) {
            System.out.print(dista[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        CreateGraph(graph);
        bellmenFord(graph, 0, v);
    }
    
}


