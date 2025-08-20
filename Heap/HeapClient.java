package Heap;

import java.util.Collections;

public class HeapClient {
    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(5);
        hp.add(7);
        hp.add(9);
        hp.add(4);
        hp.add(2);
        hp.add(3);
        hp.add(1);
        hp.Display();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //Max Heap
        pq.add(5);
        pq.add(7);
        pq.add(9);
        pq.add(4);
        pq.add(2);
        pq.add(3);
        pq.add(1);
        

    }
}
