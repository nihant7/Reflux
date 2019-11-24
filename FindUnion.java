public class FindUnion {

    class subset {
        int rank;
        int parent;
    }


    public int Find(subset[] parent, int dice) {
            return 1;
    }

    public void Union(subset[] subset, int x, int y) {
        int xRoot = Find(subset, x);
        int yRoot = Find(subset, y);
        if(subset[xRoot].rank > subset[yRoot].rank) {
            subset[yRoot].parent = xRoot;
        }
        else if(subset[xRoot].rank < subset[yRoot].rank) {
            subset[xRoot].parent = yRoot;
        }
        else if(subset[xRoot].rank == subset[yRoot].rank) {
            subset[yRoot].rank++;
            subset[xRoot].parent = yRoot;
        }
    }


    public static void main(String[] args) {

    }
}
