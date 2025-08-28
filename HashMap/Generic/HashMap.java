package HashMap.Generic;
import java.util.*;
public class HashMap <K, V> {
    class Node {
        K key;
        V value;
        Node next;
    }
    private int size =0;
    ArrayList<Node> bucket = new ArrayList<>();
    public HashMap(){
        this(4);
    }
    public HashMap(int n){
        for(int i = 0; i< n ; i++){
            bucket.add(null);
        }
    }

    public void put(K key ,V value){
        int idx = Hashfun(key);
        Node temp = bucket.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        Node nn = new Node();
        nn.key = key;
        nn.value = value;
        temp = bucket.get(idx);
        nn.next = temp;
        bucket.set(idx, nn);
        size++; 
        double lf = (1.0*size)/bucket.size();
        double thf = 2.0;
        if(lf > thf){
            rehashing();
        }  
    }

    public void rehashing(){
        ArrayList<Node> new_bukt = new ArrayList<>();
        for(int i =0; i< bucket.size()*2 ; i++){
            new_bukt.add(null);
        }
        ArrayList<Node> oba = bucket;
        bucket = new_bukt;
        size = 0;


    }

    @Override
    public String toString(){
        
    }

    public V get(K key){
        int idx =  Hashfun(key);
        Node temp = bucket.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public V remove(K key){
        int idx = Hashfun(key);
        Node curr = bucket.get(idx);
        Node prev = null;
        while(prev!= null){
            if(curr.key.equals(key)){
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if(curr == null){
            return null;
        }
        else if(prev == null){
            bucket.set(idx , curr.next);
        }else{
            prev.next = curr.next;
        }
        curr.next = null;
        size--;
        return curr.value;

    }
    public int Hashfun(K key){
        int idx = key.hashCode()%bucket.size();
        if( idx < 0) idx += bucket.size();
        return idx;
    }

}
