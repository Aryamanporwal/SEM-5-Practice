package DP;

import java.util.Arrays;

public class checkSubsequenceK {
    class Solution {
        public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
            // code here
            int dp[][]  = new int[N][K+1];
            for(int i = 0 ; i<N ; i++){
                Arrays.fill(dp[i] , -1);
            }
            return recur(arr , dp , K , 0);
        }
        public static boolean recur(int []arr , int [][]dp , int k , int idx){
            if(k==0) {
                dp[idx][k] = 1;
                return true;
            }
            
            if(idx == arr.length-1){
                if(arr[idx] == k){
                    dp[idx][k] = 1;
                    return true;
                }
                dp[idx][k] = 0;
                return false;
            }
            
            boolean pick = false;
            if(arr[idx]<=k){
                pick = recur(arr , dp , k-arr[idx] , idx+1);
                if(pick){
                    dp[idx][k] = 1;
                    return true;
                }
            }
            boolean nopick = recur(arr , dp , k , idx+1);
            dp[idx][k] = (nopick==true) ? 1: 0;
            
            return pick|| nopick;
        }
    }
}
