import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int lastStoneWeight(int[] stones) {
        int N = stones.length;
        int i = 0;

        if (N == 2 && stones[0] == stones[1]) {
            return 0;
        }

        while (N > 1) {

            if (N == 2 && stones[0] == stones[1]) {
                return 0;
            }

            Arrays.sort(stones);
            reverse(stones);

            if (stones[0] != stones[1]) {
                stones[0] = stones[0] - stones[1];
                for (int j = 2; j < stones.length; j++) {
                    stones[j - 1] = stones[j];
                }
            } else if (stones[0] == stones[1]) {
                stones[0] = 0;
                stones[1] = 0;
                Arrays.sort(stones);
                reverse(stones);


//                for (int j = 2; j < stones.length &stones[j] != 0; j++) {
//                    if(stones[0] == stones[1]) {
//                        stones[0] = 0;
//                        stones[1] = 0;
//                        Arrays.sort(stones);
//                        reverse(stones);
//                    }
//                    stones[j - 1] = stones[j];
//                }


            }

            N -= 1;
            int[] newStones = new int[N];
            for (int k = 0; k < N; k++) {
                newStones[k] = stones[k];
            }
            stones = newStones;


        }
        return stones[0];
    }

    private static int[] reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }

    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] output = new int[nums.length];


        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cnt++;
        }
        if (cnt == nums.length) return nums;


        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if(i != j) {
                    prod *= nums[j];

                    output[i] = prod;
                }

            }
            prod = 1;
        }
        return output;
    }

    private static String shiftString(int direction, int amount, String s) {

        if(direction == 0) {
            s = s.substring(amount) + s.substring(0,amount);
        }

        else if(direction ==  1) {
            int actual = s.length() - amount;
            s = s.substring(actual, s.length()) + s.substring(0, actual);
        }

        return s;
    }

    public String stringShift(String s, int[][] shift) {
        String result = "";
        for(int i = 0; i < shift.length; i++) {
                int direction = shift[i][0];
                int amount = shift[i][1];
                result = shiftString(direction, amount, s);
                s = result;
            }

        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //   s.lastStoneWeight(new int[]{2,7,4,1,8,1});

    //    s.productExceptSelf(new int[]{0,4,0});

        int[][] mat = {{0,1},
                        {1,2}};
        s.stringShift("abc", new int[][]{{0,1},{1,2}});
      //  shiftString(0,2,"abcde");
    }
}