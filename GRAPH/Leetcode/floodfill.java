package GRAPH.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class floodfill {
    class Solution {
        int totr;
        int totc;
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            totr = image.length;
            totc = image[0].length;

            boolean[][] visited = new boolean[totr][totc];
            dfs(sr , sc , color , image[sr][sc] , visited , image);

            return image;
    
        }
        void dfs(int row , int col , int newColor , int curColor , boolean visited[][] , int image[][]){
            if(row<0 || row >= totr || col<0 || col >= totc){
                return;
            }

            if(image[row][col]!=curColor){
                return;
            }

            if(visited[row][col]){
                return;
            }

            if(visited[row][col] == false && image[row][col]== curColor){
                image[row][col] = newColor;
                visited[row][col] = true;
            }

            dfs(row+1 , col , newColor , curColor , visited , image);
            dfs(row-1 , col , newColor , curColor , visited , image);
            dfs(row , col+1 , newColor , curColor , visited , image);
            dfs(row , col-1 , newColor , curColor , visited , image);
        }
    }

    //bfs
    // class Solution {
    // int rows;
    // int cols;
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     rows = image.length;
    //     cols = image[0].length;
    //     int curColor = image[sr][sc];
    //     Queue<int []> queue = new LinkedList<>();
    //     queue.offer(new int[]{sr , sc});
    //     while(!queue.isEmpty()){
    //         int node[] = queue.poll();
    //         int row = node[0];
    //         int col = node[1];
    //         int adjList[][] = {{row-1 , col} , {row , col+1} , {row+1 , col} , {row , col-1}};

    //         for(int neighbour[] : adjList){
    //             int r = neighbour[0];
    //             int c = neighbour[1];
    //             if(r<0 || r>=row || c<0 || c>=cols || image[r][c]!=curColor || image[row][col]== color){
    //                 continue;
    //             }
    //             queue.offer(new int[]{r,c});
    //             image[r][c] = color;
    //         }
    //     }
    //     return image;
    // }
// }

}
