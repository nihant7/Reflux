import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adjList[];

    Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    static void add(Graph g, int src, int dest) {
        g.adjList[src].add(dest);
        g.adjList[dest].add(src);
    }

    public void DFS (Graph g, int v) {

        boolean[] visited = new boolean[V];


        DFSUtil(visited, v);

    }

    public void DFSUtil(boolean[] visited, int v) {

        visited[v] = true;

        Iterator<Integer> i = adjList[v].iterator();
        while(i.hasNext()) {
            if(!visited[i.next()])
            visited[i.next()] = true;
        }

    }

    public void display(Graph g) {
        for(int j = 0; j < g.V; j++) {

            System.out.print(j);
            for (int vert : g.adjList[j]) {
                System.out.print("--> " + vert);

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        add(g,1,2);
        add(g,2,3);
        add(g,3,4);
        add(g,2,4);

        g.display(g);
    }
}
