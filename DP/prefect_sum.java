package DP;
public class prefect_sum {
    class Solution {

        //Top Down Approach ========================================>>>>>>
        // Function to calculate the number of subsets with a given sum
    //     public int perfectSum(int[] nums, int target) {
    //         // code here
    //         int n = nums.length;
    //         int dp[][] = new int[n][target+1];
    //         for(int i = 0; i<n  ; i++){
    //             for(int j = 0; j<target+1 ; j++){
    //                 dp[i][j] = -1;
    //             }
    //         }
    //         return recur(nums, target , n-1 , dp);
    //     }
    //     int recur(int nums[] , int target , int idx , int [][] dp) {
    //         if(idx == 0){
    //             if(target == 0 && nums[idx]==0){
    //                 dp[idx][target] = 2;
    //             return 2; 
    //             } 
    //             else if(target == 0){
    //                 dp[idx][target] = 1;
    //                 return 1;
    //             } 
    //             else if(target == nums[idx]) {
    //                 dp[idx][target] = 1;
    //                 return 1;
    //             }
    //             else {
    //                 dp[idx][target] = 0;
    //                 return 0;
    //             }
    //         }
            
    //         if(dp[idx][target] != -1){
    //             return dp[idx][target];
    //         }
    //         int pick = 0;
    //         if(nums[idx]<=target){
    //             pick = recur(nums , target- nums[idx] , idx-1 , dp);
    //         }
            
    //         int nopick = recur(nums, target , idx-1 , dp);
    //         dp[idx][target] = pick+nopick;
    //         return dp[idx][target];
    //     }
    // }

    //bottom - up ====================================>>>>>>>>>>>>>>>>>>>>
    //     public int perfectSum(int[] nums, int target) {
    //         // code here
    //         int n = nums.length;
    //         int dp[][] = new int[n][target+1];
            
    //         for(int t = 0; t<target+1 ; t++){
    //             if(t == 0 && nums[0]==0){
    //                 dp[0][t] = 2;
    //             }
    //             else if(t==0){
    //                 dp[0][t] = 1;
    //             }
    //             else if(t== nums[0]){
    //                 dp[0][t] = 1;
    //             }else{
    //                 dp[0][t] = 0;
    //             }
    //         }

    //         for(int i = 1 ; i<n ; i++){
    //             for(int j = 0 ; j<target+1 ; j++){
    //                 int pick = 0;
    //                 if(nums[i]<=j){
    //                     pick = dp[i-1][j-nums[i]];
    //                 }

    //                 int nopick = dp[i-1][j];
    //                 dp[i][j] = pick+nopick;
    //             }
    //         }
    //         return dp[n-1][target];
    //     }
    // }

    //space optimized ================================>>>
        public int perfectSum(int[] nums, int target) {
            // code here
            int n = nums.length;
            int prev[] = new int[target+1];
            
            for(int t = 0; t<target+1 ; t++){
                if(t == 0 && nums[0]==0){
                    prev[t] = 2;
                }
                else if(t==0){
                    prev[t] = 1;
                }
                else if(t== nums[0]){
                    prev[t] = 1;
                }else{
                    prev[t] = 0;
                }
            }

            for(int i = 1 ; i<n ; i++){
                int cur[] = new int[target+1];
                for(int j = 0 ; j<target+1 ; j++){
                    int pick = 0;
                    if(nums[i]<=j){
                        pick = prev[j-nums[i]];
                    }

                    int nopick = prev[j];
                    cur[j] = pick+nopick;
                }
                prev = cur;
            }
            return prev[target];
        }
    }
}
