package Abstraction;
public abstract class Abstract_demo {
    // Abstract method
    public abstract void payment();

    public abstract int No_of_items();
    // Concrete method
    public void show() {
        System.out.println("This is a concrete method.");
    }
    //koi class agar abstract h toh method ka abstract hona jaruri nahi h lekin agar koi class abstarct h toh method ka abstract hona jaruri h
    // nahi hoga toh error aayega
    // abstract class ka object nahi bna skte h


}