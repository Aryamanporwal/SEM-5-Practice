package HashMap.Generic;

import java.util.HashSet;
import java.util.Set;

public class LongestSequence {
    class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int ans = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int len = 1;
                while(set.contains(num+len)){
                    len++;
                }
                ans = Math.max(ans , len);
            }
        }
        return ans;
    }
}
}
