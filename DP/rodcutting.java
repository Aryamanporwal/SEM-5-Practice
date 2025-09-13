package DP;
public class rodcutting {
    class Solution {

        //top - down approach------------>>>>>>>>>>>>..
        // public int cutRod(int[] price) {
        //     // code here
        //     int N = price.length;
        //     //(len , Rodlen)
        //     int dp[][] = new int[N][N+1];  
        //     for(int i =0 ; i<N ; i++){
        //         for(int k = 0 ; k<N+1 ; k++){
        //             dp[i][k]= -1;
        //         }
        //     }
        //     return recur(N , N-1 , price , dp);
        // }   
        
        // public int recur(int N , int idx , int[]price , int dp[][]){
        //     //base case 
        //     if(idx == 0){
        //         dp[idx][N] = price[idx]*N;
        //         return price[idx]*N;
        //     }
            
        //     if(dp[idx][N]!=-1){
        //         return dp[idx][N];
        //     }
        //     int curlen = idx+1;
        //     int pick = 0;
        //     if(N >= curlen){
        //         pick = price[idx] + recur(N-curlen , idx , price , dp);
        //     }
        //     int nopick = recur(N , idx-1 , price , dp);
            
        //     dp[idx][N] = Math.max(pick , nopick);
        //     return dp[idx][N];
        // }


        //bottom - up approach-------------------->>>>>>>>>>>>>>

        // public int cutRod(int[] price) {
        //     // code here
        //     int N = price.length;
            
        //     //(rod , rodlen)
        //     int dp[][] = new int[N][N+1];
        //     for(int r = 0; r<N+1 ; r++){
        //         dp[0][r] = r*price[0];
        //     }
            
            
        //     for(int i =1 ; i<N ; i++){
        //         for(int k = 0 ; k<N+1 ; k++){
        //             int curlen = i+1;
        //             int pick = 0;
        //             if(k >= curlen){
        //                 pick = price[i] + dp[i][k-curlen];//recur(k-curlen , i , price , dp);
        //             }
        //             int nopick =dp[i-1][k];// recur(k , i-1 , price , dp);
        //             dp[i][k] = Math.max(pick , nopick);
        //         }
        //     }
        //     return dp[N-1][N];//recur(N , N-1 , price , dp);
        // }   


        //space optimized ------------------>>
        public int cutRod(int[] price) {
            // code here
            int N = price.length;
            
            //(rod , rodlen)
            int prev[] = new int[N+1];
            for(int r = 0; r<N+1 ; r++){
                prev[r] = r*price[0];
            }
            
            
            for(int i =1 ; i<N ; i++){
                int curr [] = new int[N+1];
                for(int k = 0 ; k<N+1 ; k++){
                    int curlen = i+1;
                    int pick = 0;
                    if(k >= curlen){
                        pick = price[i] + curr[k-curlen];//recur(k-curlen , i , price , dp);
                    }
                    int nopick =prev[k];// recur(k , i-1 , price , dp);
                    curr[k] = Math.max(pick , nopick);
                }
            }
            return prev[N];//recur(N , N-1 , price , dp);
        }  
    }
}
