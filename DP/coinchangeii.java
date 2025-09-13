package DP;

import java.util.Arrays;

public class coinchangeii {
    class Solution {
        //top-down
        // public int change(int amount, int[] coins) {
        //     int n = coins.length;
        //     int dp[][] = new int[n][amount+1];
        //     for(int i = 0; i< n  ; i++){
        //         Arrays.fill(dp[i] , -1);
        //     }
        //     int ans = recur(coins , amount , n-1 , dp);
        //     return ans;
        // }
        // public int recur(int []coins , int amount , int idx , int dp[][]){
        //     if(idx == 0){
        //         if((amount%coins[idx]) == 0){
        //             dp[idx][amount] = 1;
        //             return 1;
        //         }
        //         dp[idx][amount] = (int)(1e9);
        //         return 0;
        //     }

        //     if(dp[idx][amount]!=-1){
        //         return dp[idx][amount];
        //     }

        //     int pick = 0;
        //     if(amount>=coins[idx]){
        //         pick = recur(coins , amount-coins[idx] , idx , dp);
        //     }
        //     int nopick = recur(coins , amount , idx-1 , dp);
        //     dp[idx][amount] = pick + nopick;

        //     return pick+nopick;
        // }
        
        

        //bottom-up
        
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int dp[][] = new int[n][amount+1];
            for(int a = 0 ; a<amount+1 ; a++){
                if(a%coins[0]==0){
                    dp[0][a] = 1;
                }else{
                    dp[0][a] = 0;
                }
            }

            for(int i = 1; i<n ; i++){
                for(int a = 0 ; a<amount+1 ; a++){
                    int pick = 0;
                    if(a>=coins[i]){
                        pick = dp[i][a-coins[i]];// recur(coins , a-coins[i] , i, dp);
                    }
                    int nopick = dp[i-1][a];//recur(coins , a , i-1 , dp);
                    dp[i][a] = pick + nopick;
                }
            }

            if(dp[n-1][amount]==0){
                return 0;
            }

            return dp[n-1][amount];
        }
        }

        //space optimized 

        public int change(int amount, int[] coins) {
            int n = coins.length;
            int prev[] = new int[amount+1];
            for(int a = 0 ; a<amount+1 ; a++){
                if(a%coins[0]==0){
                    prev[a] = 1;
                }else{
                    prev[a] = 0;
                }
            }

            for(int i = 1; i<n ; i++){
                int curr[] = new int[amount+1];
                for(int a = 0 ; a<amount+1 ; a++){
                    int pick = 0;
                    if(a>=coins[i]){
                        pick = curr[a-coins[i]];// recur(coins , a-coins[i] , i, dp);
                    }
                    int nopick = prev[a];//recur(coins , a , i-1 , dp);
                    curr[a] = pick + nopick;
                }
                prev = curr;
            }

            if(prev[amount]==0){
                return 0;
            }

            return prev[amount];
        }

}
