public class FindUnion {

    int V,E;
    Edge[] edge;

    FindUnion(int V, int E) {
        this.V = V;
        this.E = E;
        for(int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }


    class Edge  {
        int src, dest;
    }

    class subset {
        int rank;
        int parent;
    }

         int find(subset[] subset, int x) {
            if (subset[x].parent == x) return x;

            else return subset[x].parent = find(subset, subset[x].parent);
        }



     //   public int Find(subset[] parent, int dice) {
     //       return 1;
     //   }

        public void Union(subset[] subset, int x, int y) {
            int xRoot = find(subset, x);
            int yRoot = find(subset, y);
            if (subset[xRoot].rank > subset[yRoot].rank) {
                subset[yRoot].parent = xRoot;
            } else if (subset[xRoot].rank < subset[yRoot].rank) {
                subset[xRoot].parent = yRoot;
            } else if (subset[xRoot].rank == subset[yRoot].rank) {
                subset[yRoot].rank++;
                subset[xRoot].parent = yRoot;
            }
        }


        public boolean isCycle(FindUnion findUnion) {
        subset[] subsets = new subset[findUnion.V];

        for(int i = 0 ; i < findUnion.V; i++) {
                subsets[i].rank = 0;
        }


            for(int i = 0; i < findUnion.E; i++) {
                int x = find(subsets, edge[i].src);
                int y = find(subsets, edge[i].dest);

                if(x == y) {
                    return true;
                }

                Union(subsets, x, y);
            }
            return false;

        }




    public static void main(String[] args) {

            FindUnion find = new FindUnion(3,3);
            Edge[] edge = new Edge[3];


            edge[0].src = 0;
            edge[0].dest = 1;

            edge[1].src = 0;
            edge[1].dest = 1;

            edge[2].src = 1;
            edge[2].dest = 2;

            find.isCycle(find);



    }
}
