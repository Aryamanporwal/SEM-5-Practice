package IntereFace;
//comparator and comparable interface 
public class car{// implements Comparable<car>{
    int price;
    int speed;
    String color;

    public car(){
        
    }

    public car(int price , int speed , String color){
        this.price = price;
        this.speed = speed;
        this.color = color;
    }

    @Override
    public String toString(){
        return "p: "+ this.price +" s: " + this.speed +" c: "+this.color;
    }

    // @Override
    // public int compareTo(car o){
    //     // return this.price-o.price;
    //     // return o.speed - this.speed;
    //     return this.color.compareTo(o.color);
    // }

}
//object ko sort krna h like , email , name , salary
//this m 2k ,o m 4k 
//jis component ki baat kr rhe ho uss component p this lagaoge
