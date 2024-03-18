import java.util.*;
public class create {
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

         //0 vertex
         graph[0].add(new Edge(0, 1, 1));
         graph[0].add(new Edge(0, 2, 1));
         //1 vertex
         graph[1].add(new Edge(1, 0, 1));
         graph[1].add(new Edge(1, 3, 1));
         //2 vertex
         graph[2].add(new Edge(2, 0, 1));
         graph[2].add(new Edge(2, 4, 1));
         //3 vertex
         graph[3].add(new Edge(3, 1, 1));
         graph[3].add(new Edge(3, 4, 1));
         graph[3].add(new Edge(2, 5, 1));
         //4 vertex
         graph[4].add(new Edge(4, 2, 1));
         graph[4].add(new Edge(4, 3, 1));
         //5 vertex
         graph[5].add(new Edge(5, 3, 1));
         graph[5].add(new Edge(5, 4, 1));
         graph[5].add(new Edge(5, 6, 1));
         //6 veretex
         graph[6].add(new Edge(6, 5, 1));
    }

    //BFS traversal
    public static void bfs(ArrayList<Edge>[] graph,int V) {
        boolean visit[]=new boolean[V];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                bfsutil(graph, visit);
            }
        }
    }
    public static void bfsutil(ArrayList<Edge>[] graph,boolean visit[]) {//O(E+V)
        Queue<Integer> q=new LinkedList<>();
        
        q.add(0);   //source = 0

        while (!q.isEmpty()) {
            int curr=q.remove();
            if (!visit[curr]) {//false in visited array
                System.out.println(curr+" ");
                visit[curr]=true;
                //add neighbour of visited node in Queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean visit[]) {
        if (src == dest) {
            return true;
        }
        visit[src]=true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);//find neighbour of source
            //e.dest= neighbour
            if (!visit[e.dest] && hasPath(graph, e.dest, dest, visit)) {
                return true;
            }
        }
        
        return false;
    }


    public static void main(String[] args) { 
        int V=7; 
        boolean visit[]=new boolean[V];
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        bfs(graph,V);
       // System.out.println(hasPath(graph, 0, 51, visit)); 
    }   
}