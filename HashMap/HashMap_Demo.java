package HashMap;

import java.util.*;
public class HashMap_Demo {
    public static void main(String[] args) {
        HashMap<String , Integer> map =  new HashMap<>();
        map.put("RAJ", 100);
        map.put("KUMAR", 200);
        map.put("Aryaman", 1000);
        map.put("Puneet" , 500);
        map.put("Ankita " , 12000);
        map.put("Swayam" , 1200000);
        System.out.println(map);

        //get
        System.out.println(map.get("RAJ"));

        //contains
        System.out.println(map.containsKey("Aryaman"));

        //remove
        System.out.println(map.remove("Puneet"));

        TreeMap<String , Integer> treeMap = new TreeMap<>(map); //sorted data
        treeMap.put("Aman", 100);
        treeMap.put("Zara", 200);
        treeMap.put("Karan", 300);
        treeMap.put("Aryaman", 400);


        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(map);
        linkedHashMap.put("Aman", 100);
        linkedHashMap.put("Zara", 200);
        linkedHashMap.put("Karan", 300);
        linkedHashMap.put("Aryaman", 400);
        System.out.println("TreeMap: " + linkedHashMap);
        

        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        System.out.println("HashSet: " + set);
        //contains

        System.out.println("Contains 20: " + set.contains(20));
        System.out.println("Contains 60: " + set.contains(60));

        //remove
        set.remove(30);
        System.out.println("After removing 30: " + set);

        TreeSet<Integer> treeSet = new TreeSet<>(set); //sorted data
        treeSet.add(5);
        treeSet.add(15);
        treeSet.add(25);
        System.out.println("TreeSet: " + treeSet);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(set); //insertion order preserved
        linkedHashSet.add(5);
        linkedHashSet.add(15);
        linkedHashSet.add(25);
        System.out.println("LinkedHashSet: " + linkedHashSet);


        for( x : set){
            System.out.println(x);
        }
        for( x : treeSet){
            System.out.println(x);
        }
        for( x : linkedHashSet){
            System.out.println(x);
        }

        for(String k : map.keySet()){
            System.out.println("Key: " + k + ", Value: " + map.get(k));
        }
        

    }

}
