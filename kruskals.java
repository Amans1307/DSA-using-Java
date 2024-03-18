import java.util.*;
public class kruskals {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }

        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }

    static void creatrGraph(ArrayList<Edge> edges){
        //edges graph implemented using adjacency list
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n=4;//vertices
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);//return find(par[x])
    }

    public static void union(int a,int b) {
        int parA=find(a);
        int parB=find(b);

        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;//rank will be increaded by 1 bcoz2 same rank tree is connecting
        }
        else if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        }else{
            parent[parB] = parA;
        }
    }

    //kruskals algo
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges);
        int mstcost=0;
        int count= 0;

        for (int i = 0; count < V-1; i++) {
            Edge e = edges.get(i);
            //src,dest,wt
            int parA= find(e.src);//src = a
            int parB= find(e.dest);// src = b
            if (parA != parB) {// not cycle
                union(e.src, e.dest);
                mstcost += e.wt;
                count++;
            }
        }
        System.out.println(mstcost);
    }

    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges = new ArrayList<>();
        creatrGraph(edges);
        kruskalsMST(edges, V);
    }
}
