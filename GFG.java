import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.*;


//@Retention(RetentionPolicy.CLASS)
@Retention(RetentionPolicy.RUNTIME)
//@Retention(RetentionPolicy.SOURCE)
@interface Add
{
    public int id();
    public String name();
}
public class GFG extends Solution2 {

    private static String getRandomHexString(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
            while (sb.length() < numchars) {
                sb.append(Integer.toHexString(r.nextInt()));
            }
        return sb.toString().substring(0, numchars);
    }





    @Add(name = "Nihant", id = 123)
    public static void
    getCustomAnnotation()
    {

        try {

            // create class object for class name GFG
            Class c = GFG.class;

            // get method name getCustomAnnotation as Method object
            Method[] methods = c.getMethods();
            Method method = null;
            for (Method m : methods) {
                if (m.getName().equals("getCustomAnnotation"))
                    method = m;
            }

            // get an array of Annotations
            Annotation[] annotation = method.getDeclaredAnnotations();

            // get annotation from the array of annotation
            // and print the details
            for (Annotation a : annotation) {

                Add self = (Add)a;
                // Print annotation attribute
                System.out.println("Annotation details");
                System.out.println("key: " + self.name());
                System.out.println("value: " + self.id());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean createIDs(String partnerId, String siteId) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < 5; i++) {
            String id = getRandomHexString(3);
            String puuid = partnerId + "-" + siteId + "-" + id;
            list.add(puuid);
        }
        System.out.println(list);
        return true;
    }

    int increment(int i) {
        i++;
        return i;
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        for(Map.Entry entry : map.entrySet()) {
           if(entry.getValue().equals(1)) {
               res = (int) entry.getKey();
           }
        }

        return res;
    }

    private static int squareSum(int a, int b) {
        double res = 0;
        res = Math.pow(a,2) + Math.pow(b,2);
        return (int)res;
    }

    public int maxSubArray(int[] nums, int sum, int maxSum) {
        int[] dp = new int[nums.length];
        dp[0] = 0;

        if(nums.length == 1) return nums[0];

        for(int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }


            }
            sum = 0;
        }
        return maxSum;
    }

    public void moveZeroes(int[] arr) {
        int[] extra = new int[arr.length];
        int j = 0;

        for(int i = 0 ; i < arr.length; i++) {
            if(arr[i] != 0) {
                extra[j++] = arr[i];
            }
        }
        arr = extra;
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int countZeroes(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                sum += 1;
            }
        }
        return sum;
    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i-1] < prices[i]) {
                sum += (prices[i] - prices[i-1]);
            }
        }
        return sum;
    }

    public boolean isHappy(int n) {
        boolean flag = false;
        int sum = 0;
        int m = n;
        HashSet<Integer> happy = new HashSet<Integer>();

        while(happy.add(n)) {
            while (n > 0) {
                sum = sum + (int) Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
            sum = 0;
        }
        return n == 1;
    }


    public List<List<String>> groupAnagrams(String[] str) {
        List<String> subTotal = new ArrayList<String>();
        List<List<String>> total = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < str.length; i++) {
            char[] charArray = str[i].toCharArray();
            Arrays.sort(charArray);
            String word = new String(charArray);

            if(map.containsKey(word)) {
                words = map.get(word);
                words.add(str[i]);
                map.put(word, words);

            }

                else {
                    words = new ArrayList<>();
                    words.add(str[i]);
                    map.put(word, words);

            }
            }
            for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
                  total.add(entry.getValue());
            }
            return total;

         }


    public int countElements(int[] arr) {

        Arrays.sort(arr);
        int count = 0;
        for(int i = 0 ; i < arr.length; i++) {
                for(int j = i+1; j < arr.length; j++) {
                    if(arr[j] - arr[i] == 1) {
                        count++;
                        break;
                    }
                }
        }

        return count;

    }

    private static boolean charCheck(char input_char) {
        // CHECKING FOR ALPHABET
        if ((input_char >= 65 && input_char <= 90)
                || (input_char >= 97 && input_char <= 122))
            return true;
        else return false;
    }

    public static String removeCharAt(int index, String str) {
        return str.substring(0, index) + str.substring(index+1);
    }



    private static String copy(String S) {
        // "ac##"
        StringBuffer extra = new StringBuffer();
        for(int i = S.length() - 1; i >= 0 ; i--) {
            if (S.charAt(i) != '#' && i >= 0 && charCheck(S.charAt(i))) {
                extra.append(S.charAt(i));
            }
            else  {
                int c = 0;
                int j = i;
                while( j >= 0) {

                    if(S.charAt(j) == '#') {
                        j--;
                        c++;
                    }
                    else if(charCheck(S.charAt(j)) && c > 0) {
                        j--;
                        c--;
                    }
                    else break;
                }
//                while( c > 0 ) {
//                    i--;
//                    c--;
//                }
                i = j;
                i += 1;
                if(i == 0) break;
            }
        }
        return extra.reverse().toString();
    }

    public boolean backspaceCompare(String S, String T) {
        String s = copy(S);
        String t = copy(T);
        if(s.equals(t)) return true;
        else return false;
    }



    private static boolean isAnagram(String word1, String word2) {
        if(word1 == null && word2 == null) return false;

        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        Arrays.sort(charArray1); Arrays.sort(charArray2);
        if(Arrays.equals(charArray1,charArray2)) return true;
        else return false;
    }


    public static void main(String[] args) {
        GFG s1 = new GFG();


     //   getCustomAnnotation();
        int[][] edges = {{0, 3},
                         {1, 3},
                         {2, 3},
                         {4, 3},
                         {5, 4}};



        //int[] nums = {1,2,2};
        int[] nums = {-2,1,-3,4,-1,2,1};
      //  Arrays.sort(nums);
        int res = 0;

        int[] arr = {1,1,2,2};

     //   s1.maxSubArray(nums, 0, -2);
     //       s1.moveZeroes(arr);
    //    System.out.println(GFG.countZeroes(arr));

        int[] stock = {7,1,5,3,6,4};
      //  s1.maxProfit(stock);
       // System.out.println(s1.isHappy(19));

        String[] str = {"eat", "tan", "tea", "ate", "nat", "bat"};
     //  s1.groupAnagrams(str);
        //    s1.countElements(arr);
               s1.backspaceCompare("ab##",
                       "c#d#");
        //System.out.println(copy("ab#c"));


        //    System.out.println(s1.singleNumber(nums));

      //  System.out.println(s1.increment(++i));

    }




}
