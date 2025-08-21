package Heap.Leetcode;

import java.util.*;

public class IPO {
    public static void main(String[] args) {
        int k = 2, w =0;
        int [] profits = {1,2,3}, capital = {0,1,1};
        int [][] arr = new int[profits.length][2];
        for(int i = 0 ; i<profits.length ; i++){
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        System.out.println(IPOA(k, w , arr));
    }
    public int IPOA(int k, int w, int[][] arr) {
        Arrays.sort(arr , (a,b)->a[0]-b[0]);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i = 0; i<arr.length ; i++){
            if(w >= arr[i][0]){
                pq.add(arr[i]);
                i++;
            }
            if(pq.isEmpty()|| k == 0) {
                return w;
            }

            w+= pq.poll()[1];
            k--;
        }
        while(!pq.isEmpty() && k >0){
            w+= pq.poll()[1];
            k--;
        }
        return w;
    }
}
