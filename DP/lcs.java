package DP;

import java.util.Arrays;

// public class lcs {
//     class Solution {
//         public int longestCommonSubsequence(String s1, String s2) {
//             int [][] dp = new int [s1.length()][s2.length()];
//             for(int [] a: dp){
//                 Arrays.fill(a , -1);
//             }
//             return  LCS(s1, s2, 0 , 0 ,dp);
//         }
//         public int LCS(String s1, String s2 , int i , int j , int [][]dp){
//             if(i==s1.length() || j==s2.length()){
//                 return 0;
//             }
//             if(dp[i][j]!=-1){
//                 return dp[i][j];
//             }
//             int ans = 0;
//             if(s1.charAt(i)==s2.charAt(j)){
//                 ans = 1+LCS(s1, s2 , i+1 , j+1 , dp);
//             }else{
//                 int f = LCS(s1, s2, i+1 , j , dp);
//                 int s = LCS(s1 , s2 , i , j+1 , dp);
//                 ans = Math.max(f , s);
//             }
//             return dp[i][j] = ans;
//         }
//     }
// }

class Solution {
    public int secondLargest(int[] nums) {
        int max = Integer.MIN_VALUE,
        second = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second && num != max) {
                second = num;
            }
        }
        return second;
    }
}