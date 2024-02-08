package code.Nira.Graph;
import java.util.*;
public class BellmanFord {
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

    static void CreateGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmenFord(ArrayList<Edge> graph[], int src) {
        int dista[] = new int[graph.length];
        for(int i=0; i<dista.length; i++) {
            if(i != src) {
                dista[i] = Integer.MAX_VALUE;
            }
        }

        int T = graph.length;

        for(int i=0; i<T-1; i++) {
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dista[u] != Integer.MAX_VALUE && dista[u] + wt < dista[v]) {
                        dista[v] = dista[u]+wt;
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
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        bellmenFord(graph, 0);
    }
    
}
