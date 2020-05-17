package demo.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class StudentDemo {



    public static void main(String[] args) {
        Student st = new Student("Rob", 21, 100);
        Student st1 = new Student("Bob", 25, 50);
        Student st2 = new Student("Mike", 20, 12);

        ArrayList<Student> collect = new ArrayList<>();

        collect.add(st);
        collect.add(st1);
        collect.add(st2);

        Collections.sort(collect, new NameComparator());


        for(int i = 0 ; i < collect.size(); i++)
            System.out.println(collect.get(i).getName());

        Collections.sort(collect, new AgeComparator().reversed());

        for(int i = 0 ; i < collect.size(); i++)
            System.out.println(collect.get(i).getAge());

        StudentDemo sd = new StudentDemo();




    }


}
