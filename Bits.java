public class Bits {

    public int calcNumberMissing(int[] arr) {
        int res = arr[0];
        for(int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

    public int calcAllNumberMissing(int[] arr1) {
        int res = arr1[0];
        for(int i = 1; i < arr1.length; i++) {
            res ^= arr1[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] arr1 = {1,2,3,5,6,7};
        Bits b = new Bits();
        System.out.println(b.calcNumberMissing(arr)^b.calcAllNumberMissing(arr1));
        System.out.println(b.calcAllNumberMissing(arr1));
    }
}
