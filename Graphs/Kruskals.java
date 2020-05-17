package Graphs;

import java.util.Arrays;

public class Kruskals {

    // Steps
    // find min weighted edge

    Edge[] edges;
    int V;

    Kruskals(int V) {
        for(int i = 0; i < V; i++) {
            edges[i] = new Edge();
        }
    }

    class subset {
        int rank, parent;
    }


    class Edge implements Comparable<Edge> {

        int weight, src, dest;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public int find(subset[] subset, int i) {

        return 0;
    }

    public void union(subset[] subsets, int x, int y) {

        if(subsets[x].rank  > subsets[y].rank) {
            subsets[x].parent = y;
        }
        else if(subsets[y].rank > subsets[x].rank) {
            subsets[y].parent = x;
        }
        else {
            subsets[x].parent = y;
            subsets[y].rank++;
        }
    }


    public void kruskalMST() {

        Edge[] result = new Edge[V];
        Arrays.sort(edges);

        subset[] subsets =  new subset[V];

        int e = 0;

        for(int i = 0; i < V; i++) {
            subsets[i].rank = 0;
        }

        while(e < V - 1) {
            Edge newEdge = new Edge();
            newEdge = edges[e++];


            int x = find(subsets, newEdge.src);
            int y = find(subsets, newEdge.dest);

            if(x != y) {
                union(subsets, x, y);
                result[e++] = newEdge;
            }

        }


    }
}
