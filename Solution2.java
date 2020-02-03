import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Solution2 {
    public static void main(String[] args) {



     //   System.out.println(PrimalityTest(7));

        Integer[] arr = new Integer[] {1,2,3};
        Integer[] arr1 = new Integer[]{4,5,6};

      List<List<Integer>> list = new ArrayList<>();
      list.add(Arrays.asList(arr));
      list.add(Arrays.asList(arr1));

        Iterator itr = list.get(1).iterator();
      while(itr.hasNext()) {
          System.out.println(itr.next());
      }

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