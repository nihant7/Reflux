public class Prims {

    private static final int V = 5;

    int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int c = 0; c < V; c++) {
            if(mstSet[c] == false && key[c] < min) {
                min = key[c];
                index = c;
            }
        }
        return index;
    }




    public void Prims(int[][] graph) {

        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] mstSet = new boolean[V];

        parent[0] = -1;
        key[0] = 0; // Start from here

        for(int j = 0; j < mstSet.length; j++) {
            mstSet[j] = false;
        }

        for(int i = 0; i < V - 1; i++) {
            int u = minKey(key, mstSet);
            for(int v = 0; v < V; v++) {
                if(graph[u][v] == 1 && mstSet[v] == false && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
    }
}
