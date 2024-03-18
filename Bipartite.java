import java.util.*;
public class Bipartite {
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
    
         //4 vertex
         graph[4].add(new Edge(4, 2, 1));
         graph[4].add(new Edge(4, 3, 1));
        
    }

    public static boolean isbipartite(ArrayList<Edge> graph[],int src) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i]=-1;//no color
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {//BFS(node is not traverse or colored)
                q.add(i);
                color[i]=0;//yellow color
                while (!q.isEmpty()) {//same as BFS algorithm
                    int curr=q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {//for all neighbour
                        Edge e = graph[curr].get(j);//e.dest
                        if (color[e.dest] == -1) {//case 1
                          int nextColor = color[curr] == 0 ? 1 : 0;  //finding current node color
                          color[e.dest] = nextColor;
                          q.add(e.dest);
                        }
                        //case 2
                        else if (color[e.dest] == color[curr]) {
                            return false;   //not bipartite
                        }

                    }
                }
            }
        }
        return true;
    }


    //If graph doesnt have cycle then it is always BIPARTITE Graph
    public static void main(String[] args) {
        int V=7; 
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        System.out.println(isbipartite(graph, V));
    }
}
