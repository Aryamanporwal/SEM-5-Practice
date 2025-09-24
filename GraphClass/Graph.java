package GraphClass;
import java.util.*;
public class Graph {

    private HashMap<Integer, HashMap<Integer , Integer>> map;
    public Graph(int v){
        map = new HashMap<>();
        for(int i = 1 ; i<= v ; i++){
            map.put(i , new HashMap<>());
        }
    }

    public void AddEdge(int v1 , int v2 , int cost){
        map.get(v1).put(v2 , cost);
        map.get(v2).put(v1 , cost);
    }
    public boolean ContainsEdge(int v1 , int v2){
        return map.get(v1).containsKey(v2);
    }
    public boolean Containsvertex(int v1){
        return map.containsKey(v1);
    }

    public int noofEdge(){
        int sum = 0;
        for(int v : map.keySet()){
            sum = sum + map.get(v).size();
        }
        return sum/2; //because a to b and b to a is calculated 
    }

    public void removeEdge(int v1 , int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void removevertex(int v1){
        for(int neighbour : map.get(v1).keySet()){
            map.get(neighbour).remove(v1);
        } //delete all the nodes to which v1 is connected
        map.remove(v1);
    }

    public void Display(){
        for(int v: map.keySet()){
            System.out.println(v+" "+map.get(v));
        }
    }
    public boolean hasPath(int src , int des , HashSet<Integer> visited){
        if(src == des) return true;
        visited.add(src);
        for(int nbrs : map.get(src).keySet()){
            if(!visited.contains(nbrs)){
                boolean ans = hasPath(nbrs , des , visited);
                if(ans) return ans;
            }
        }
        return false;
    }

    public void PrintPath(int src , int des , HashSet<Integer> visited, String ans){
        if(src == des){
            System.out.println(ans);
            return;
        }

        visited.add(src);
        for(int nbrs : map.get(src).keySet()){
            if(!visited.contains(nbrs)){
                PrintPath(nbrs , des , visited , ans+src);
            }
        }
        visited.remove(src);
    }   

    public static void main(String[] args) {
        Graph g = new Graph(7); //7 vertex hai jispe numbering 1 to 7

        g.AddEdge(1,4,2);
        g.AddEdge(1, 2, 5);
        g.AddEdge(3, 2, 7);
        g.AddEdge(3, 4, -1);
        g.AddEdge(5, 4, 3);
        g.AddEdge(5, 6, 7);
        g.AddEdge(5, 7, 8);
        g.AddEdge(7, 6, 4);
        System.out.println(g.hasPath(1,6 , new HashSet<>()));
        g.Display();
        g.PrintPath(1 , 6 , new HashSet<>() , "");

   }

}
