public class ArrayRotation {



    public static void main(String[] args) {
        ArrayRotation ar = new ArrayRotation();
        int[] arr = {1,2,3,4,5};
        display(arr);
        bigRotate(arr, 3);
        System.out.println();
        display(arr);
    }

    private static void display(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bigRotate(int[] arr, int d) {
        for (int i = 0; i < d; i++ ) {
            rotate(arr);
        }
    }

    private static int[] rotate(int[] arr) {
        int n = arr.length;
        int temp = arr[0];
        int i = 1;
        while (i < n) {
            arr[i-1] = arr[i];
            i++;
        }
        arr[n-1] = temp;
        return arr;
    }
}
