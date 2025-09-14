package GRAPH.Leetcode;

public class centerOfStarGraph {
    class Solution {
        public int findCenter(int[][] edges) {
            // HashMap<Integer , Integer> freqmap = new HashMap<>();
            // int n = edges.length;
            // for(int i = 0; i<n ; i++){
            //     int u = edges[i][0];
            //     int v = edges[i][1];
            //     freqmap.put(v , freqmap.getOrDefault(v , 0)+1);
            //     freqmap.put(u , freqmap.getOrDefault(u , 0)+1);

            //     if(freqmap.get(v)==n){
            //         return v;
            //     }

            //     if(freqmap.get(u)==n){
            //         return u;
            //     }
            //     return -1;
            // }

            //just find common nodes beccause it is graph graph

            int pair1 [] = edges[0];
            int pair2 [] = edges[1];

            if(pair1[0] == pair2[0] || pair1[0] == pair2[1]){
                return pair1[0];
            }
            return pair1[1];
        }
    }
}
