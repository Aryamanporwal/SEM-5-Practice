package GRAPH.GFG;

import java.util.ArrayList;

public class dfsOfGraph {
    class Solution {
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
            // Code here
            ArrayList<Integer> res = new ArrayList<>();
            int V = adj.size();
            boolean visited[] = new boolean[V];
            for(int i = 0; i<V ; i++){
                if(!(visited[i])){
                    dfs(i , visited , adj , res );
                }
            }
            return res;
        }
        
        public void dfs(int node , boolean visited[]  , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> res){
            visited[node] = true;
            res.add(node);
            for(int neighbour : adj.get(node)){
                if(!(visited[neighbour])){
                    dfs(neighbour , visited , adj , res);
                }
            }
        }
    }
}
