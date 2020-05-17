import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Solution2 {
    public static void main(String[] args) throws FileNotFoundException {

//    int[] arr = {1,2,3,4,5,6,7};
//    int[] candies = new int[arr.length];
//
//    for(int i = 0; i < arr.length; i++) {
//        System.out.println(candies[arr[i]++]);
//    }

     //   System.out.println(longestSubstring("PROGRAMMING"));

        Solution2 sol = new Solution2();
      //  sol.primalityArray(25);

        int[] arr = {4,6,4,5,6,2};
        Solution2.candies(arr.length, arr);


    }


    static long candies(int n, int[] arr) {
        int sum = 0;
        int[] candies = new int[arr.length];
        for(int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        if(arr[0] > arr[1]) {
            candies[0] += 1;
        }
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i] > arr[i-1] || arr[i] > arr[i+1]) {
                candies[i] = candies[i-1] + 1;
                if(candies[i-1] == candies[i] && candies[i-1] > candies[i]) {
                    candies[i-1] += 1;
                    if(candies[i-1] == candies[i] && candies[i-1] > candies[i]) {
                        candies[i-1] += 1;
                    }
                }
            }
            else {
                candies[i] = 1;
            }
        }

        if(arr[n-1] > arr[n-2]) {
            candies[n-1] += 1;
        }

        for(int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }

    static int maxMin(int k, int[] arr) {
        if(arr.length == 1) return arr[0];
        else {
            Arrays.sort(arr);
            int result = arr[k-1] - arr[0];
            return result;
        }
    }

    public boolean[] primalityArray(int N) {
        boolean[] primes = new boolean[N];
        for(int i = 0; i < N ; i++) {
                primes[i] = true;
                int a = Math.min(5,4);
        }



        for(int j = 2; j*j <= N; j++) {

            if(primes[j] == true) {
                for(int p = j*j; p < N; p+=j) {
                    primes[p] = false;
                }
            }
        }
        for(int i = 0; i < primes.length; i++) {

            if(primes[i] == true)
                System.out.print(i + ":" + primes[i] + ",");
        }
        return primes;
    }



    public static Map<Character, Integer> longestSubstring(String str) {
        String newString = String.valueOf(str.charAt(0));

        HashMap<Character, Integer> counter = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(counter.get(i) == null){
                counter.put(str.charAt(i), i+1);
            }

            else if (!isContains(newString, str, i)) {
                counter.put(str.charAt(i), i);
            }
        }
        return counter;
    }

    private static boolean isContains(String word, String str, int i) {
        if(word.contains(String.valueOf(str.charAt(i)))) {
            return true;
        }
        else return false;
    }

    private static boolean isBlank(String str) {
       if(str == "") return true;
       else return false;
    }




    public static boolean PrimalityTest(int num) {
        boolean flag = true;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }



}