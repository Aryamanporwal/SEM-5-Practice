package IntereFace;

//samarth
public interface StackI {
    public void push(int item);
    public void pop();
    public void peek();

    //body nhi dete h by default abstarct nature ka hoga and acc to java8 agar method static h toh body de sakte h
    public static final int x =90; //ye update nhi ho sakte h in objects
    //interface m variable ko value dena jruri h
    //final mtlb ye update nhi ho sakta h
    //static mtlb ye kisi bhi object k liye nahi hoga
    //ye class k andar nahi hoga ye interface k andar hoga
    //isi class k pehle final likha h toh inherit nhi ho sakta h
    //kisi method k agge final likha h toh override nhi ho sakta h

    //java8
    static void f1(){

    }

    default void f2(){ //default method ko body de sakte h interface m
    }

    //java 9
    private void name(){
        //private bhi ban sakte h
    }

    public void fun();
}
