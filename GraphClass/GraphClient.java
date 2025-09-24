package GraphClass;
import java.util.*;
public class GraphClient {
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

   }
}
