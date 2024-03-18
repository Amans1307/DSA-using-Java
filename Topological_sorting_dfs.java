import java.util.*;
public class Topological_sorting_dfs {
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

    public static void toposorting(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> s= new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                topoSortutil(graph,i,visit,s);//modified dfs
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    public static void topoSortutil(ArrayList<Edge>[] graph,int curr, boolean visit[],Stack<Integer> s) {
        visit[curr]=true;
   
        for (int i = 0; i < graph[curr].size(); i++) {//only when node is unvisited
            Edge e=graph[curr].get(i);
            if (!visit[e.dest]) {
                topoSortutil(graph, e.dest, visit, s);
            }
        }

        s.push(curr);
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        toposorting(graph);
    }
}
