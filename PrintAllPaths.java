import java.util.*;

public class PrintAllPaths {

    static class Edge{
        int src;
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

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
    }
    public static void printAllPaths(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int target){

        //Base Case
        if(curr == target){
            System.out.println(path + " ");
            return;
        }

        //we iterate on a loop to find list of all neighbours
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            //check for unvisited neighbour
            if(vis[e.dest] == false){
                vis[curr] = true;
                printAllPaths(graph,vis,e.dest,path+e.dest, target);
                vis[curr] = false;
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        int src = 0;
        int target = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean vis[] = new boolean[V];
        printAllPaths(graph, vis, src, "0", target);
    }
}
