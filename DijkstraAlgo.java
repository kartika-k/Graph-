import java.util.*;

public class DijkstraAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    //Pair class which is form ----> pair(node, dist)
    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }
    //dijkstra fun is similar to bfs fun
    public static void dijkstra(ArrayList<Edge> graph [], int V, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int [V];
        for(int i=0; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];

        //now we will add our first shortest distance node i.e the src node into pq
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();    //finding shortest dist element or pair and popping from queue
            //now we will check if our curr node is not visited yet then mark as visited
            if(!vis[curr.node]){
                vis[curr.node] = true;

                //now we will find all the NBRS of curr node
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;

                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        //after updating distance now add this pair into queue
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        //now we will print distance of all nodes from src node
        for(int i=0; i<V; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph []= new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, V, 0);
    }
}
