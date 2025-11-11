package GraphClass.Leetcode;
// Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

// Example 1:

// Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
// Output: true
import java.util.*;
public class Graph_valid_tree {
    class solution{
        public boolean validTree(int n , int[][] edges){
            HashMap<Integer , List<Integer>> map = new HashMap<>();

            for(int i = 0; i<n ; i++){
                map.put(i , new ArrayList<>());
            }

            for(int i = 0; i<edges.length ; i++){
                int v1 = edges[i][0];
                int v2 = edges[i][1];

                map.get(v1).add(v2);
                map.get(v2).add(v1);
            }
            return BFT(map);


        }
        public boolean BFT(HashMap<Integer , List<Integer>> map){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int c =0;
        for(int src : map.keySet()){
            if(visited.contains(src)) continue;
            c++;
            q.add(src);
            while(!q.isEmpty()){
                // 1. remove
                int r = q.poll();
                // 2. ignore if already visited
                if(visited.contains(r)) return false;
                
                // 3. mark visited
                visited.add(r);

                // 4. add unvisited nbrs
                for(int nbrs : map.get(r)){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }

        }
        return true;
    }

    }
}
