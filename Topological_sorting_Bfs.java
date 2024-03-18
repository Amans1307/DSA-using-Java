import java.util.*;
public class Topological_sorting_Bfs {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
         graph[2].add(new Edge(2, 3, 1));
         graph[3].add(new Edge(3, 1, 1));
         graph[4].add(new Edge(4, 0, 1));
         graph[4].add(new Edge(4, 1, 1));
         graph[5].add(new Edge(5, 0, 1));
         graph[5].add(new Edge(5, 2, 1));
    }

    public static void calcindegree(ArrayList<Edge> graph[],int indegree[]) {
        for (int i = 0; i < graph.length; i++) {
            int v=i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }
    public static void toposort(ArrayList<Edge> graph[]) {
        int indegree[] = new int[graph.length];
        calcindegree(graph,indegree);
        Queue<Integer> q= new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr+" ");//topological sorting

            for (int i = 0; i < graph[curr].size(); i++) {//doing neighbour --
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
   public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        toposort(graph);
   } 
}
