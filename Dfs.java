import java.util.*;

public class Dfs {

    static class Edge{
        int src ;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){

        //on any level , first we have to mark curr as visited for that first we will print curr
        System.out.print(curr + " ");
        vis[curr] = true;

        //Now to visit all neighbours we will apply one loop
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //now check for unvisited node
            if(vis[e.dest] == false){
                //if unvisited node is present then call the dfs function recursively for visiting neighbours
                dfs(graph,e.dest,vis);
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;

        boolean vis[] = new boolean[V];

        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);
        dfs(graph,0,vis);
    }
}
