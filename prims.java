import java.util.*;//incomplete continue after exam
public class prims {
    static class edge{
        int src;
        int dest;
        int weight;
        public edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }

    public static void createGraph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>(null);
        }
        graph[0].add(new edge(0, 1, 10));
        graph[0].add(new edge(0, 2, 15));
        graph[0].add(new edge(0, 3, 30));

        graph[1].add(new edge(1, 0, 10));
        graph[1].add(new edge(1, 3, 40));

        graph[2].add(new edge(2, 0, 15));
        graph[2].add(new edge(2, 3, 50));

        graph[3].add(new edge(3, 1, 40));
        graph[3].add(new edge(3, 0, 30));
        graph[3].add(new edge(3, 2, 50));
    }

    static class Pair{
        int v;
        int cost;

        public Pair(int v, int c){
            this.v=v;
            this.cost=c;
        }
    }

    public static void prim(ArrayList<edge> graph[]) {
        boolean vis[]= new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
    }

    public static void main(String[] args) {
        int V= 5;
        ArrayList<edge> graph[]= new ArrayList[V];
        createGraph(graph);
    }
}
