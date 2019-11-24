public class Solution {
    public void reverse(int[] nums) {
        for (int i = 0; i < nums.length/2; i++) {
           swap(nums, nums.length - i - 1, i);
        }
    }

    private static void swap(int[] arr, int num, int num1) {
        int tmp = arr[num];
        arr[num] = arr[num1];
        arr[num1] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5};
        display(nums);
        s.reverse(nums);
        System.out.println();
        display(nums);
    }

    private static void display(int[] nums) {
        for(int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + " ");
        }
    }
}
