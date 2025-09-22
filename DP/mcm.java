package DP;

public class mcm {
    public static void main(String [] args){
        int [] arr = { 4, 2, 3 , 5, 1};
        int [][] dp = new int[arr.length][arr.length];
        System.out.println(mcm(arr , 0 , arr.length-1 , dp));
    }

    public static int mcm(int [] arr , int i , int j , int [][]dp){
        if ( i+1 == j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i+1 ; k<j ; k++){
            int fs = mcm(arr , i , k, dp); //i*k
            int ss = mcm(arr , k , j , dp); //k*j
            int self = arr[i] * arr[k] * arr[j]; // [i*k] * [k*j]
            dp[i][j] = Math.min(ans , fs+ss+self);
            ans = Math.min(ans , fs+ss+self);
        }
        return ans;
    }
} 