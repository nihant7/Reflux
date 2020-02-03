import sun.jvm.hotspot.memory.CMSCollector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CompareDemo  {


    public static void main(String[] args) {
        User user = new User("Joe", 35);
        User user1 = new User("Rob", 20);
        User user2 = new User("Bob", 40);


        ArrayList<User> al = new ArrayList<User>();
        al.add(user);
        al.add(user1);
        al.add(user2);

        Collections.sort(al);

        System.out.println(al.get(0).id);


    }
}
