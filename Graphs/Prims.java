package Graphs;

public class Prims {


    class Edge implements Comparable<Edge> {
        int verts;
        int edge;
        int weight;

        public Edge(int verts, int edge) {
            this.verts = verts;
            this.edge = edge;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


    public static void main(String[] args) {
        int i=0 ,j = 0;
        while(i < 5) {
            j++;
            if(j%5 == 0)
                i++;
            System.out.println(j);
        }
    }


}
