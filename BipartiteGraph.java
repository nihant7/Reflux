import java.util.LinkedList;

public class BipartiteGraph {
    int V;
    LinkedList<Integer> adj[];

    BipartiteGraph(int V) {
        this.V = V;
        adj = new LinkedList[V];

        for(int i = 0; i < V; i++) {
            // Assign each array location to a list
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
    }

//    public boolean isSafe(int[][] graph, boolean[] visited, int v, int V) {
//        for(int i = 0; i < V; i++)
//        if(graph[v][i] == 1 && !visited[i])
//            return true;
//        else return false;
//    }

//    public void HCycle(int[][] graph, int V) {
//
//
//        boolean[] visited = new boolean[V];
//            for(int v = 0; v < V; v++) {
//                if(isSafe(graph, visited, v, V)) {
//                    visited[v] =  true;
//                }
//
//            }
//
//
//    }


    public void MatrixToList(int[][] graph) {
            for(int i = 0; i < graph.length; i++) {
                for(int j = 0; j < graph[0].length; j++) {
                    if(graph[i][j] == 1) {
                        addEdge(i,j);
                    }
                }
            }
    }

    static void printGraph(BipartiteGraph g)
    {
        for(int v = 0; v < g.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: g.adj[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }



    public static void main(String[] args) {
        int[][] graph = {
                {0,1,0,0},
                {1,0,1,1},
                {0,1,0,0},
                {0,1,0,0}
        };

        BipartiteGraph g = new BipartiteGraph(4);
        g.MatrixToList(graph);

        printGraph(g);
    }
}
