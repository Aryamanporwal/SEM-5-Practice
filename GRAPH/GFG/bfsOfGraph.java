package GRAPH.GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsOfGraph {
    class Solution {
        // Function to return Breadth First Search Traversal of given graph.
        public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
            // code here
            int V = adj.size();
            boolean visited[] = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();
            ArrayList<Integer> res = new ArrayList<>();
            visited[0] = true;
            queue.offer(0);
            while(!queue.isEmpty()){
                int node = queue.poll();
                res.add(node);
                for(int neighbour: adj.get(node)){
                    if(!visited[neighbour]){
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
            
            
            return res;
        }
    }
}
