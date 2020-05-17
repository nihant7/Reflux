public class InheritingBehavior {

    interface Engine {
        default String model() {
            return "1990";
        }
    }

    interface Vehicle {
        default String make() {
            return "Honda";
        }
    }

    class Car implements Engine, Vehicle {
        Car c = new Car();
        public String makeAndModel() {
               return c.make() + c.model();
            }

    }

    public static void main(String[] args) {
        InheritingBehavior ib = new InheritingBehavior();
        ib.countTotal(5);
    }

    static int num(int N) {
        int count = 0;
            while(N != 0) {
                count += N & 1;
                N = N >> 1;
        }
        return count;
    }

    int[] countTotal(int number) {
        int[] result = new int[number + 1];
        for (int i = 0; i < number + 1; i++) {
            result[i] = num(i);
        }
        return result;
    }

    void kCut(int[] arr, int n, int k) {
        int i = 0, j = 0, l = arr.length, sum1 = 0, sum2 = 0;
        int prod = 1;

        for(i = 0; i < n; i++) {


            while (i < k) {
                prod *= arr[i++];
            }
                if (j < i) {
                    sum1 += arr[j];
                }

                if (l < i) {
                    sum2 += arr[l];
                }
            }

    }

}
