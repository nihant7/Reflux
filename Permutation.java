import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Java program to print all permutations of a
// given string.
public class Permutation
{

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static ArrayList<ArrayList<Integer>> getPowerSetRecursion(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        if(set.size()==index){
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>()); //Empty set
            System.out.println(allSubsets);
        }
        else{
            allSubsets = getPowerSetRecursion(set,index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset:allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moresubsets.add(newSubset);
            }
            allSubsets.addAll(moresubsets);
        }
        return allSubsets;
    }


    public static void main(String[] args)
    {
        Permutation p = new Permutation();
        p.getPerms("ABC", "",0);
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private Set<String> permute(String str, int l, int r)
    {
        Set<String> set = new HashSet<>();
        {
            for (int i = 0; i <= r; i++)
            {
                for(int j = 0; j <= r; j++) {
                    str = swap(str, i, j);
                    set.add(str);
                }

             //   str = swap(str,l,i);
            }
        }
        return set;
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public void getPerms(String str, String curr, int index) {

        if(index == str.length()) {
            System.out.println(curr);
            return;
        }

        getPerms(str, curr, index+1);
        getPerms(str, curr + str.charAt(index), index+1);

    }

}

// This code is contributed by Mihir Joshi
