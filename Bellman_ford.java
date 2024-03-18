import java.util.*;
public class Bellman_ford {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

         //0 vertex
         graph[0].add(new Edge(0, 1, 2));
         graph[0].add(new Edge(0, 2, 4));
         //1 vertex
         graph[1].add(new Edge(1, 2, -4));
        // graph[1].add(new Edge(1, 3, 1));
         //2 vertex
         graph[2].add(new Edge(2, 3, 2));
        // graph[2].add(new Edge(2, 4, 1));
         //3 vertex
        // graph[3].add(new Edge(3, 1, 1));
         graph[3].add(new Edge(3, 4, 4));
    
         //4 vertex
         graph[4].add(new Edge(4, 1, -1));
        // graph[4].add(new Edge(4, 3, 1));
        
    }

    public static void bellmanford(ArrayList<Edge> graph[],int src,int V) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //algo
        for (int i = 0; i < V-1; i++) {
            //edges - O(E)
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                }
            }
        }
    }

    public static void main(String[] args){
        int V=5; 
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
    
    }
}
