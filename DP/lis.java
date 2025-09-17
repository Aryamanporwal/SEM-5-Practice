package DP;

import java.util.Arrays;
import java.util.*;
public class lis {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int lis [] = new int[n];
            Arrays.fill(lis , 1);
            int maxlen = 1;
            for(int i = 0; i<n ; i++){
                for(int p = 0 ; p<i ; p++){
                    if(nums[i] > nums[p]){
                        lis[i] = Math.max(lis[i] , 1+lis[p]);
                    }
                }
                if(lis[i]>maxlen){
                    maxlen = lis[i];
                }
            }
            return maxlen;
            
        }
    }
}
