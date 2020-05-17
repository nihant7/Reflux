package sorts;

public class CountingSort {

    public static void sort(int[] arr) {

        {
            int n = arr.length;

            // The output character array that will have sorted arr
            int output[] = new int[256];

            // Create a count array to store count of inidividul
            // characters and initialize count array as 0
            int count[] = new int[256];
            for (int i=0; i<n; ++i)
                count[i] = 0;

            // store count of each character
            for (int i=0; i<n; ++i)
                ++count[arr[i]];

            for (int i=1; i<=255; ++i)
                count[i] += count[i-1];

            // Build the output character array
            // To make it stable we are operating in reverse order.
            for (int i = 1; i<n+1; i++)
            {
                output[count[arr[i]]-1] = arr[i];
                --count[arr[i]];
            }

            // Copy the output array to arr, so that arr now
            // contains sorted characters
            for (int i = 0; i<n; ++i)
                arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        char[] num = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's'
        };

        int[] number = {1,4,1,2,7,5,2};
        sort(number);
    }
}
