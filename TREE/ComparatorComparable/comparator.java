package ComparatorComparable;
import java.util.*;
public class comparator {
    public static void main(String[] args) {
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp("Durgesh" , "324156" , 12));
        emps.add(new Emp("Aryaman" , "324196" , 10));
        emps.add(new Emp("Swayam" , "724156" , 15));
        System.out.println(emps);
        Collections.sort(emps ,new IdComparator());
        System.out.println(emps);

        ArrayList<Emp> emps1 = new ArrayList<>(emps);
        Collections.sort(emps1, new NameComparator());
    }
}
