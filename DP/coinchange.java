package DP;

import java.util.Arrays;

public class coinchange {
    class Solution {
    //     public int coinChange(int[] coins, int amount) {
    //         int n = coins.length;
    //         int dp[][] = new int[n][amount+1];
    //         for(int i = 0 ; i<n ; i++){
    //             Arrays.fill(dp[i] , -1);
    //         }
    //         int ans = recur(coins , amount , n-1 , dp);
    //         if(ans == (int)(1e9)){
    //             return -1;
    //         }
    //         return ans;
    //     }

    //     public int recur(int []coins , int amount , int idx , int[][] dp){
    //         //base case
    //         if(idx==0){
    //             if(amount%coins[idx]==0){
    //                 dp[idx][amount] = amount/coins[idx];
    //                 return (amount/coins[idx]);
    //             }
    //             dp[idx][amount] = (int)(1e9);
    //             return (int)(1e9);
    //         }

    //         if(dp[idx][amount]!=-1){
    //             return dp[idx][amount];
    //         }

    //         int pick = (int)(1e9);
    //         if(amount>=coins[idx]){
    //             pick = 1+recur(coins , amount-coins[idx] , idx , dp);
    //         }
    //         int nopick = recur(coins , amount , idx-1 , dp);
    //         dp[idx][amount] = Math.min(pick , nopick);
    //         return Math.min(pick , nopick);
    //     }

    //bottom UP
    //     public int coinChange(int[] coins, int amount) {


    //         int n = coins.length;
    //         int dp[][] = new int[n][amount+1];
    //         for(int a=0; a<amount+1 ; a++){
    //             if(a%coins[0]==0){
    //                 dp[0][a] = a/coins[0];
    //             }else{
    //                 dp[0][a] = (int)(1e9);
    //             }
    //         }


    //         for(int i = 1 ; i<n ; i++){
    //             for(int a = 0 ; a<amount+1 ; a++){
    //                 int pick = (int)(1e9);
    //                 if(a>=coins[i]){
    //                     pick = 1+ dp[i][a-coins[i]];//recur(coins , a-coins[i] , i , dp);
    //                 }
    //                 int nopick = dp[i-1][a];//recur(coins , a , i-1 , dp);
    //                 dp[i][a] = Math.min(pick , nopick);
    //             }
    //         }
    //         if(dp[n-1][amount] == (int)(1e9)){
    //             return -1;
    //         }
    //         return dp[n-1][amount];
    //     }

    //space optimized------------>>>>>>>>>>
    
    public int coinChange(int[] coins, int amount) {
        // int n = coins.length;
        // int dp[][] = new int[n][amount+1];
        // for(int i = 0 ; i<n ; i++){
        //     Arrays.fill(dp[i] , -1);
        // }
        // int ans = recur(coins , amount , n-1 , dp);
        // if(ans == (int)(1e9)){
        //     return -1;
        // }
        // return ans;
    
        int n = coins.length;
        int prev[] = new int[amount+1];
        for(int a=0; a<amount+1 ; a++){
            if(a%coins[0]==0){
                prev[a] = a/coins[0];
            }else{
                prev[a] = (int)(1e9);
            }
        }
    
    
    
        for(int i = 1 ; i<n ; i++){
            int curr[] = new int[amount+1];
            for(int a = 0 ; a<amount+1 ; a++){
                int pick = (int)(1e9);
                if(a>=coins[i]){
                    pick = 1+ curr[a-coins[i]];//recur(coins , a-coins[i] , i , dp);
                }
                int nopick = prev[a];//recur(coins , a , i-1 , dp);
                curr[a] = Math.min(pick , nopick);
            }
            prev = curr;
        }
    
        if(prev[amount] == (int)(1e9)){
            return -1;
        }
        return prev[amount];
        
    }
    

    }    


}

