package Heap;
import java.util.*;
public class MeetingRooms {
    public static void main(String[] args) {
        int [][] intervals = {{10,30}, {15,20}, {5,10}, {2,6},{12,18},{19,25},{1,5},{3,5}};
        meeting(intervals);
    }
    public static int meeting(int[][] intervals){
         Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
         PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
         pq.add(intervals[0]);
         for(int i =1 ; i<intervals.length ; i++){
            if(intervals[i][0] >= pq.peek()[1]){
                pq.poll();
            } 
                pq.add(intervals[i]);
            }
            return pq.size();
    }
}
