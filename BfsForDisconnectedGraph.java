import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsForDisconnectedGraph {

    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createDisGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));

    }

    public static void bfs(ArrayList<Edge> graph[], int vertex, boolean vis[], int start){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }
    public static void main(String[] args) {
        int vertex = 5;

        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createDisGraph(graph);

        boolean vis[] = new boolean[vertex];
        for(int i=0; i<vertex; i++){
            if(vis[i] == false){
                bfs(graph,vertex,vis,i);
            }
        }
    }
}
