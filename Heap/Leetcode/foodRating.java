package Heap.Leetcode;

import java.util.*;

public class foodRating {
    class Pair{
    String food;
    int rating;
    Pair(String f , int r){
        this.food = f;
        this.rating = r;
    }
}

class FoodRatings {

    HashMap<String  , Integer> fr = new HashMap<>();
    HashMap<String , PriorityQueue<Pair>> map = new HashMap<>();
    HashMap<String , String > cf = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = cuisines.length;
        for(int i = 0; i<n ; i++){

            fr.put(foods[i] , ratings[i]);
            cf.put(foods[i] , cuisines[i]);
            map.putIfAbsent(cuisines[i] , new PriorityQueue<>((a, b)->{
                if(b.rating == a.rating) return a.food.compareTo(b.food);
                return b.rating - a.rating;
            }));
            map.get(cuisines[i]).add(new Pair(foods[i] , ratings[i]));
        }

    }
    
    public void changeRating(String food, int newRating) {
        //cuisine wale map m update jisme pair tha
        fr.put(food , newRating);
        String cuisine = cf.get(food);
        map.get(cuisine).add(new Pair(food , newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = map.get(cuisine);
        while(true){
            Pair top = pq.peek();
            if(fr.get(top.food) == top.rating){
                return top.food;
            }
            pq.poll();
        } 
        
    }
}
}
