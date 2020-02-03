import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] a = {0,1,0,2,3,4,5,6,5};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i])+1);
            }
            else  {
                map.put(a[i], 1);
            }
        }
        System.out.println(map);
    }


}
