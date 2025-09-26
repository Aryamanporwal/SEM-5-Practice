package DP;
import java.util.*;
public class perfect_sum {
    class Solution {
        // Function to calculate the number of subsets with a given sum
        public int perfectSum(int[] nums, int target) {
            // code here
            int n = nums.length;
            Arrays.sort(nums);
            int dp[][] = new int[n][target+1];
            for(int i = 0; i<n ; i++){
                Arrays.fill(dp[i] , -1);
            }
            return recur(nums , target , 0, dp);
        }
        public int recur(int []arr , int k , int idx, int dp[][] ){
            if(idx==arr.length-1){
                if(k == 0 && arr[idx]==0){
                    dp[idx][k] = 2;
                    return 2;
                }
                else if(k==0){
                    dp[idx][k] = 1;
                    return 1;
                }
                else if(arr[idx]==k){
                    dp[idx][k] = 1;
                    return 1;
                }
                else{
                    dp[idx][k]= 0;
                    return 0;
                }
            }
            
            if(dp[idx][k]!=-1){
                return dp[idx][k];
            }
            int pick = 0;
            if(arr[idx]<=k){
                pick = recur(arr , k-arr[idx] , idx+1 , dp);
            }
            int nopick = 0;
            nopick = recur(arr ,k , idx+1 , dp);
            
            dp[idx][k] = pick+nopick;
            return dp[idx][k];
        }
    }
}
