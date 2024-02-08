package code.Nira.Graph;
import java.util.*;
public class Bipartite {
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


        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));


        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));


        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int j=0; j<graph.length; j++) {
            if(col[j] == -1) {
                q.add(j);
                col[j] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int i=0; i<graph[curr].size(); i++) {
                        Edge e = graph[curr].get(i);
                        if(col[e.dist] == -1) {
                            int nextcol = col[curr] == 0 ?1 : 0;
                            col[e.dist] = nextcol;
                            q.add(e.dist);
                        } else if(col[e.dist] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int v =5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
