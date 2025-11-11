package GraphClass;
import java.util.*;
public class Graph_2 {
    private HashMap<Integer, HashMap<Integer , Integer>> map;
    public Graph_2(int v){
        map = new HashMap<>();
        for(int i = 1 ; i<= v ; i++){
            map.put(i , new HashMap<>());
        }
    }

    public static void main(String[] args) {
        Graph_2 g = new Graph_2(7); //7 vertex hai jispe numbering 1 to 7

        g.AddEdge(1,4,2);
        g.AddEdge(1, 2, 5);
        g.AddEdge(3, 2, 7);
        g.AddEdge(3, 4, -1);
        g.AddEdge(5, 4, 3);
        g.AddEdge(5, 6, 7);
        g.AddEdge(5, 7, 8);
        g.AddEdge(7, 6, 4);
        System.out.println(g.BFS(1,6));

   }

    public void AddEdge(int v1 , int v2 , int cost){
        map.get(v1).put(v2 , cost);
        map.get(v2).put(v1 , cost);
    }


    public boolean BFS(int src , int des){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            // 1. remove
            int r = q.poll();
            // 2. ignore if already visited
            if(visited.contains(r)) continue;
            // 3. mark visited
            visited.add(r);
            // 4. self work
            if(r==des) return true;
            // 5. add unvisited nbrs
            for(int nbrs : map.get(r).keySet()){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
    public void BFT(){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int src : map.keySet()){
            q.add(src);
            while(!q.isEmpty()){
                // 1. remove
                int r = q.poll();
                // 2. ignore if already visited
                if(visited.contains(r)) continue;
                // 3. mark visited
                visited.add(r);
                // 4. self work
                System.out.println(r+" ");
                // 5. add unvisited nbrs
                for(int nbrs : map.get(r).keySet()){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }
        }
    }

    public boolean DFS(int src , int des){
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        st.push(src);
        while(!st.isEmpty()){
            //1 . remove
            int r = st.pop();
            // 2. ignore if already visited
            if(visited.contains(r)) continue;
            // 3. mark visited
            visited.add(r);
            // 4. self work
            if(r==des) return true;
            // 5. add unvisited nbrs
            for(int nbrs : map.get(r).keySet()){
                if(!visited.contains(nbrs)){
                    st.push(nbrs);
                }
            }

        }
        return false;
    }
    public void DFT(){
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int src : map.keySet()){
            st.push(src);
            while(!st.isEmpty()){
                //1 . remove
                int r = st.pop();
                // 2. ignore if already visited
                if(visited.contains(r)) continue;
                // 3. mark visited
                visited.add(r);
                // 4. self work
                System.out.println(r+" ");
                // 5. add unvisited nbrs
                for(int nbrs : map.get(r).keySet()){
                    if(!visited.contains(nbrs)){
                        st.push(nbrs);
                    }
                }
    
            }
        }
    }
}
