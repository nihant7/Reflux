public class ConnectRopes {

    public int calcRopeCost(int[] ropes) {
        int[] cost = new int[ropes.length];
        cost[0] = ropes[0];
        for(int i = 1; i < ropes.length; i++) {
            cost[i] = cost[i-1] + ropes[i];
        }
        int sum = 0;
        for(int i = 1 ; i < cost.length; i++) {
            sum += cost[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ropes = {4,3,2,6};
        ConnectRopes c = new ConnectRopes();
        System.out.println(c.calcRopeCost(ropes));
    }
}
