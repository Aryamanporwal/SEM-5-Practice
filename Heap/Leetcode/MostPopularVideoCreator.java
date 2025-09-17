package Heap.Leetcode;

import java.util.*;


public class MostPopularVideoCreator {
    class Pair{
    String id;
    int view;
    Pair(String i , int v){
        this.id = i;
        this.view = v;
    }
}
class Solution {
        HashMap<String, Long> cv = new HashMap<>();
        HashMap<String , PriorityQueue<Pair>> map = new HashMap<>();
        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

            List<List<String>> ans = new ArrayList<>();
            int n = creators.length;
            for(int i = 0; i<n ; i++){

                cv.put(creators[i] , cv.getOrDefault(creators[i] , 0L)+ views[i]);
                map.putIfAbsent(creators[i] , new PriorityQueue<>((a, b)->{
                    if(a.view == b.view) return a.id.compareTo(b.id);
                    return b.view - a.view;
                }));
                map.get(creators[i]).add(new Pair(ids[i] , views[i]));
            }

            long maxView = 0;
            for(long total : cv.values()){
                maxView = Math.max(maxView , total);
            }

            for(String creator : cv.keySet()){
                if(cv.get(creator) == maxView){
                    Pair top = map.get(creator).peek();
                    ans.add(Arrays.asList(creator , top.id));
                }
            }
            return ans;
            
        }
    }
}
