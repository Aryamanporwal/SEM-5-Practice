package GraphClass.Leetcode;

import java.util.*;

public class Is_Graph_Bipartite {
    class BipartitePair{
        int vertex;
        int distance;
        BipartitePair(int v , int d){
            this.vertex = v;
            this.distance = d;
        }
    }
    public boolean isBipartite(int[][] graph) {
            Queue<BipartitePair> q = new LinkedList<>();
            HashMap<Integer , Integer> visited = new HashMap<>();
            for(int i = 0; i<graph.length ; i++){
                if(visited.containsKey(i)) continue;
                q.add(new BipartitePair(i, 0));
                while (!q.isEmpty()) {
                    //1. remove
                    BipartitePair rp = q.poll();
                    //2. ignore
                    if(visited.containsKey(rp.vertex)){
                        if(visited.get(rp.vertex) != rp.distance){
                            return false;
                        }
                        continue;
                    }
                    //3. marked visit
                    visited.put(rp.vertex , rp.distance);
                    //4. self work
                    //5. add unvisited nbrs
                    for(int nbrs: graph[rp.vertex]){
                        if(!visited.containsKey(nbrs)){
                            q.add(new BipartitePair(nbrs , rp.distance+1));
                        }
                    }
                }
            }

        return true;
    }
    
}
