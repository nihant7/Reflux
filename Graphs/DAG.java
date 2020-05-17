package Graphs;

import java.util.*;

public class DAG {

    public int V;

    List<ArrayList<Integer>> adj;

    DAG(int V) {
            adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }

    public void doDFS(int V) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[V];


        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        stack.push(0);

        while(!stack.isEmpty()) {
            int top = stack.pop();
            System.out.print(top + " ");

            if(visited[top] == false) {
                visited[top] = true;
            }

            Iterator<Integer> itr = adj.get(top).iterator();
            while(itr.hasNext()) {
                int nxt = itr.next();
                if (visited[nxt] == false) {
                    visited[nxt] = true;
                    stack.push(nxt);
                }
            }
        }


    }

    public void doBFS(int V) {
        Queue<Integer> queue = new LinkedList<>();


        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++) {
            visited.add(i,false);
        }
        queue.add(2);
        visited.add(2,true);

        while(!queue.isEmpty()) {
            int neigh = queue.poll();

            System.out.print(neigh + " ");


            Iterator<Integer> u = adj.get(neigh).iterator();
            while(u.hasNext()) {
                if(visited.get(u.next()).equals(false)) {
                    visited.add(u.next(),true);
                    queue.add(u.next());
                }
            }
        }
    }

    public int display() {
        int label = -1;
        for(int i = 0; i < adj.size(); i++) {
            Iterator<Integer> u = adj.get(i).iterator();
            while(u.hasNext()) {
                Integer v = u.next();
                if(v == i) {
                    label = -1;
                }
                else if(v != i) {
                    label = v;
                }
            }
        }
        return label;
    }


    public static void main(String[] args) {
        DAG g = new DAG(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println(g.adj.size());
      //  g.display();
        //g.doBFS(4);
    }
}
