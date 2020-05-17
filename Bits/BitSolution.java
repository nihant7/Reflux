package Bits;

import java.util.ArrayList;
import java.util.List;

public class BitSolution {

    public int oddElement(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }


    // Reverse bits 1,1,0,1 to 1,0,1,1
    public int reverseBits(int n) {
        int top = 0;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        while(n != 0) {
            top = n & 1;
            list.add(top);
            n >>= 1;

        }

        for(int i = 0; i < list.size(); i++) {
            res <<= 1 ;
            res = res | list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        BitSolution b = new BitSolution();
        int[] nums = {2,2,2,2,3,3,3,3,4,4,4,4,4,4,4};
        int n = 12;
        System.out.println(b.reverseBits(n));
        System.out.println(b.oddElement(nums));
    }
}


