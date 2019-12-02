import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {
    int v;
    LinkedList<Integer> adjList[];

    TopologicalSorting(int verts) {
        v = verts;
        adjList = new LinkedList[verts];
        for(int j = 0; j < verts; j++) {
            adjList[j] = new LinkedList();
        }
    }

    public void addEdge(int s, int d) {
        adjList[s].add(d);
    }

    public void topo(int v) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[v];
        for(int i = 0; i < v ; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                topoUtil(i,visited,stack);
            }
        }
        System.out.println(stack);
    }


    // Util to add the vertices adjacent to "i"
    private void topoUtil(int i, boolean[] visited, Stack<Integer> stack) {
        Iterator<Integer> u = adjList[i].iterator();
        while(u.hasNext()) {
            int nextVert = u.next();
            if(visited[nextVert] == false) {
                visited[nextVert] = true;
                stack.push(nextVert);
            }
        }
            stack.push(i);
    }

    public static void main (String[] args) {
        int verts = 6;
        TopologicalSorting g = new TopologicalSorting(verts);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topo(verts);
    }
}
