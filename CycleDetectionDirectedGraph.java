import java.util.ArrayList;

public class CycleDetectionDirectedGraph {

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
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
    }
    public static boolean isCycleDirected(ArrayList<Edge> graph[], int curr, boolean vis[], boolean recStack[]){

        //on starting with the first node mark it as visited
        vis[curr] = true;
        recStack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //Cycle condition
            if(recStack[e.dest] == true){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleDirected(graph, e.dest, vis, recStack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        System.out.println(isCycleDirected(graph, 0, vis, recStack));
    }
}
