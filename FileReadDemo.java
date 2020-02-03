import java.io.*;
import java.util.*;

public class FileReadDemo {

    public void maxWord(File file) throws IOException {
        ArrayList<String> al = new ArrayList<>();
        String[] words = {};
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine().trim();
        while(line != null) {

            words = line.split("\\W+");

            for(String word : words) {
                if(word != null) {
                    al.add(word.trim());

                }

            }
            line = br.readLine();

        }
        Collections.sort(al);
        System.out.println(al);
        getMaxOccurrence(al);


    }

    private ArrayList<String> getMaxOccurrence(ArrayList<String> al) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        int i = 0;
        for(String word : al) {
            if (word != null & !word.isEmpty()) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word)+1);
                } else {
                    map.put(word, 1);
                }
            }
        }
    //    System.out.println(map);
        ArrayList<String> list = getList(map);
        return list;
    }

    private ArrayList<String> getList(TreeMap<String, Integer> map) {
        ArrayList<String> list = new ArrayList<String>();
        int max = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= max) {
                max = entry.getValue();
                list.add(entry.getKey());
            }
        }
        return list;
    }


    public static void main(String[] args) throws IOException {
        FileReadDemo fd = new FileReadDemo();
        fd.maxWord(new File("/Users/nihantg/Desktop/text.txt"));
    }
}
