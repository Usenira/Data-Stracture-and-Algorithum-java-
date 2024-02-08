package code.Nira.Graph;
import java.util.*;


public class Path {

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
         
            graph[0].add(new Edge(0, 3));
            
            graph[2].add(new Edge(2, 3));
    
            graph[3].add(new Edge(3, 1));
           
            graph[4].add(new Edge(4, 0));
            graph[4].add(new Edge(4, 1));
    
            graph[5].add(new Edge(5, 0));
            graph[5].add(new Edge(5, 2));
        }
    
    public static void PrintPath(ArrayList<Edge>[] graph, int src, int dist, String path) {
        if(src == dist) {
            System.out.println(path+dist);
        }

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            PrintPath(graph, e.dist, dist, path+src);
        }
    }
    
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);

        int src = 5, dist = 1;
        PrintPath(graph, src, dist, "");
    }
}
