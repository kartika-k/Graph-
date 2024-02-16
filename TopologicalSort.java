import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src =  s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }
    //this is modified dfs function
    public static void topologicalSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack){

        vis[curr] = true;

        //apply loop for finding all neighbours of curr node
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            //then visit all the unvisited node
            if(!vis[e.dest]){
                //call for neighbours
                topologicalSortUtil(graph, e.dest, vis, stack);
            }
        }
        //Now push curr node to the top of stack
        stack.push(curr);
    }
    //function to find toplogical sort
    public static void topSort(ArrayList<Edge> graph[], int V){
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++){
            //check for all the unvisited node
            if(!vis[i]){
                topologicalSortUtil(graph,i,vis,stack);
            }
        }
        //now pop all the elemnts from stack
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph, V);
    }
}
