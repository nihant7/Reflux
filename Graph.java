import java.util.Iterator;
import java.util.*;

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

    public void add(Graph g, int src, int dest) {
        g.adjList[src].add(dest);
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


    // Stack Implementation
    public void doDFS (int v) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        java.util.Stack<Integer>  stack = new java.util.Stack<>();
        stack.push(v);

        while(!stack.isEmpty()) {

            int popped = stack.pop();


             visited[popped] = true;

            System.out.print(popped + " ");
            Iterator<Integer> neighbor = adjList[popped].iterator();
            while(neighbor.hasNext()) {
                int vert = neighbor.next();
                if(!visited[vert]) {
                    visited[vert] = true;
                    stack.push(vert);
                }
              }
            }
        }


        public void BFS(int v) {

            boolean[] visited = new boolean[V];
            for(int i = 0; i < V; i++)
                visited[i] = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;



            while(!queue.isEmpty()) {

            int top = queue.remove();
            System.out.print(top + " ");

                Iterator<Integer> neighbor = adjList[top].listIterator();
                while(neighbor.hasNext()) {
                    int vert = neighbor.next();
                    if(!visited[vert]) {
                        visited[vert] = true;
                        queue.add(vert);
                    }
                }
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


    // LeetCode problem
    public static int findJudge(int N, int[][] trust) {
       // trust = new int[N][N];
        int label = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < trust.length; j++) {
               // System.out.print("trust"+"["+i+"]"+"["+j+"]: " + trust[i][j]);
                if(trust[i][j] == 1 && trust[i][j] != trust[j][i]) {
                    label = j;
                    break;
                }
                else { label = -1; }
            }
            return label;
        }
        return label;
    }


    public static void main(String[] args) {
//        Graph g = new Graph(4);
//        g.add(g,0, 1);
//        g.add(g,0, 2);
//        g.add(g,1, 2);
//        g.add(g,2, 0);
//        g.add(g,2, 3);
//        g.add(g,3, 3);
//
//
//        //   g.display(g);
//
//        // DFS
//        g.doDFS(1);
//        System.out.println();
//        // BFS
//        g.BFS(2);
        int[][] trust = {
                         {0,0,1},
                         {0,0,0},
                         {0,0,0}
                        };
        System.out.print(findJudge(3, trust));
    }
}
