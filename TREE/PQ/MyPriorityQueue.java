package PQ;

import java.util.*;

class newStudent {
    int marks;
    String name;
    newStudent(String name , int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "Student name : " + this.name +" marks: "+ this.marks;
    }  
    @Override 
    public int compareTo(newStudent that){

        
        // return this.marks - that.marks; //inc - asc
        return that.marks - this.marks; //dec - desc

    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof newStudent){
            newStudent that = (newStudent) obj;
            if(this.marks == that.marks && this.name.compareTo(that.name)==0){
                return true;
            }
        }
        return false;
    }

}
public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        minpq.offer(1);
        minpq.offer(2);
        minpq.offer(4);
        minpq.offer(6);
        System.out.println("Highest Priority element->" + minpq.peek());

        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        maxpq.offer(1);
        maxpq.offer(2);
        maxpq.offer(10);
        maxpq.offer(0);
        System.out.println("Highest Priority element->" + maxpq.peek());
        System.out.println("deleted->"+maxpq.poll());
        System.out.println("Highest Priority Element->"+maxpq.element());
        System.out.println(maxpq.contains(10));

        PriorityQueue<newStudent> minStudents = new PriorityQueue<>();
        newStudent ns = new newStudent("aryaman", 90);
        // minStudents.offer(ns);
        minStudents.offer(new newStudent("Jaan", 89));
        minStudents.offer(new newStudent("Babu" , 87));
        System.out.println(minStudents.peek());

        System.out.println(minStudents.peek());
        System.out.println(minStudents.contains(new newStudent("aryaman" , 90))); //false
        // System.out.println(ns); //true


    }
}
