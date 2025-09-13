package GRAPH;
import java.util.*;
public class Graph {
    int adjMatrix[][];
    List<List<Integer>> adjList;
    List<List<Pair>> adjListWithWt;
    class Pair{
        int node;
        int weight;
        Pair(int n , int w){
            node = n;
            weight = w;
        }

        @Override
        public String toString(){
            return "(" + node + "," + weight + ")";
        }
    }
    Graph(int nodes){
        adjMatrix = new int[nodes][nodes]; //4*4 [0...]
        adjList = new ArrayList<>();
        adjListWithWt = new ArrayList<>();
        for(int i =0 ; i<nodes ; i++){
            adjList.add(new ArrayList<>());
            adjListWithWt.add(new ArrayList<>());
        }
    }
//   -> [[0,2] , [0,1] , [2,0]]
    public void addEdgesInMatrix(int edges[][] , boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(isDirected){
                //directed
                adjMatrix[u][v] = 1;
            }else{     
                //undirected 
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }

        }

    }

    
    public void addEdgesInList(int edges[][] , boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(isDirected){
                //directed
                adjList.get(u).add(v);
            }else{     
                //undirected 
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

        }

    }

    
    public void addEdgesWtInList(int edges[][] , boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(isDirected){
                //directed
                Pair pair = new Pair(v , w);
                adjListWithWt.get(u).add(pair);
            }else{     
                //undirected 
                Pair pair1 = new Pair(v,w);
                Pair pair2 = new Pair(u,w);
                adjListWithWt.get(u).add(pair1);
                adjListWithWt.get(v).add(pair2);
            }

        }

    }

    
    public void addEdgeswithWtInMatrix(int edges[][] , boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(isDirected){
                //directed
                adjMatrix[u][v] = w;
            }else{     
                //undirected 
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }

        }

    }


    public void printMatrix(){
        for(int i = 0; i <adjMatrix.length ; i++){
            System.out.print("Row "+ i +" -> ");
            for(int j = 0 ; j< adjMatrix[i].length ; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 0->[1,2]
    // 1->[0]
    public void printList(){
        for(int i = 0; i <adjList.size(); i++){
            System.out.print(i + " -> ");
            System.out.print("[");
            for(int j = 0; j<adjList.get(i).size() ; j++){
                System.out.print(adjList.get(i).get(j)+" , ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printWtList(){
        for(int i = 0; i <adjListWithWt.size(); i++){
            System.out.print(i + " -> ");
            System.out.print("[");
            for(int j = 0; j<adjListWithWt.get(i).size() ; j++){
                System.out.print(adjListWithWt.get(i).get(j)+" , ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void findDegreeInUndirectedGraph(int edges[][] , int nodes){
        int degree[] = new int[nodes];
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }

        //print 
        for(int i = 0; i<nodes; i++){
            System.out.println("node -> "+ i + " degree -> "+ degree[i]);
        }
    }

    public void findDegreeInDirectedGraph(int edges[][] , int nodes){
        int indegree[] = new int[nodes];
        int outdegree[] = new int[nodes];
        for(int edge[] : edges){
            int from = edge[0];
            int to = edge[1];
            indegree[to]++;
            outdegree[from]++;
        }

        //print 
        for(int i = 0; i<nodes; i++){
            System.out.println("node -> "+ i + " in-degree -> "+ indegree[i]);
            System.out.println("node -> "+ i + " out-degree -> "+ outdegree[i]);
        }
    }


    public static void main(String []args){
        int edges[][] = {{0,2} , {0,1} , {1,3}};
        int nodes = 4;
        //undirected graph
        Graph graph = new Graph(nodes);
        graph.addEdgesInMatrix(edges  , false);
        System.out.println("undirected graph");
        graph.printMatrix();

        //directed graph 
        Graph graphdir = new Graph(nodes);
        graphdir.addEdgesInMatrix(edges, true);
        System.out.println("directed graph"); 
        graphdir.printMatrix();

        //weighted directed graph 
        int edges1[][] = {{0,2,10} , {0,1,10} , {1,3,30}};
        Graph wtedgraphdir = new Graph(nodes);
        wtedgraphdir.addEdgeswithWtInMatrix(edges1 , true);
        System.out.println("weighted directed graph"); 
        wtedgraphdir.printMatrix();



        //adjList --------------------->>

        
        //undirected graph List
        Graph graph3 = new Graph(nodes);
        graph3.addEdgesInList(edges  , false);
        
        System.out.println("undirected graph List");
        graph3.printList();

        //directed graph 
        Graph graphdir3 = new Graph(nodes);
        graphdir3.addEdgesInList(edges, true);
        System.out.println("directed graph"); 
        graphdir3.printList();

        //weighted directed graph 
        // int edges3[][] = {{0,2,10} , {0,1,10} , {1,3,30}};
        Graph wtedlistdir = new Graph(nodes);
        wtedlistdir.addEdgesWtInList(edges1 , true);
        System.out.println("weighted directed list"); 
        wtedlistdir.printWtList();

        //-----undirected graph-----------
        System.out.println("Undirected Graph degree");
        Graph graphdeg = new Graph(4);
        graphdeg.findDegreeInUndirectedGraph(edges, 4);

        System.out.println("Directed Graph degree");
        Graph graphdegwt = new Graph(nodes);
        graphdegwt.findDegreeInDirectedGraph(edges1 , nodes);
    }
}
