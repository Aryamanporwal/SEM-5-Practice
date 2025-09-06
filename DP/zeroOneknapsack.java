package DP;

public class zeroOneknapsack {
    class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int [][] dp = new int[n][W+1];
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<W+1 ; j++){
                dp[i][j] = -1;
            }
        }
        return recur(W , val , wt, n-1 , dp);
    }
    
    static int recur(int w , int [] val , int []wt , int idx , int [][]dp){
        if(w == 0){
            dp[idx][w]= 0;
        }
        if(idx == 0){
            if(wt[idx]<=w){
                dp[idx][w] = val[idx];
                return val[idx];
            }
            else{
                dp[idx][w] = 0;
                return 0;
            }
        }
        if(dp[idx][w]!= -1){
            return dp[idx][w];
        }
        int pick = 0;
        if(wt[idx]<=w){
            pick = val[idx] + recur(w-wt[idx] , val , wt , idx-1 , dp);
        }
        int nopick = 0 + recur(w, val , wt, idx-1 , dp);
        dp[idx][w] = Math.max(pick , nopick);
        return dp[idx][w];
    }
}

}
