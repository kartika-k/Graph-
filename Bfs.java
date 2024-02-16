import java.util.*;

public class Bfs {

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
    public static void bfs(ArrayList<Edge> graph[], int vertex){

        //First we will create a queue . we will not create a queue from scratch instead we will 
        //import from library which is inbuilt queue

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[vertex];

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;

                //Now add neighbours of current node into queue
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
        createGraph(graph);
        bfs(graph,vertex);
    }
}
