import java.util.*;

public class CreateGraph{

    //Edge class of graph - This is static template of how our edge will look
    static class Edge{
        int src;
        int dest;

        //Making an Edge Constructor
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
     //Now we will make a function to create a graph
    public static void createGraph(ArrayList<Edge> graph[]){
        //initially in array there are null values therefore we need to create an empty arraylist 
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();   //empty arraylist is created
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

    }
    public static void main(String[] args) {
        int vertex = 4;

        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);

        //Print all neighbours of 2
        for(int i=0; i<graph[i].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }

    }
}