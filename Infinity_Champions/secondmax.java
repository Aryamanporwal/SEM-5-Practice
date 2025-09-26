package Infinity_Champions;

import java.util.HashSet;

public class secondmax {
    class Solution {
        public int secondHighest(String s) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if ((int) (s.charAt(i)) >= 48 && (int) (s.charAt(i)) <= 57) {
                    set.add((int) (s.charAt(i)) - 48);
                }
            }
            int n = set.size();
            // int arr[] = new int[n];
            // int j= 0;
            // for(int i : set){
            // arr[j] = i;
            // j++;
            // }

            // Arrays.sort(arr);
            // return (n>=2) ? arr[n-2]:-1;

            // approach two----------------->>>>
            int max = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            for (int num : set) {
                if (num > max) {
                    second = max;
                    max = num;
                } else if (num > second && num != max) {
                    second = num;
                }
            }
            return (second == Integer.MIN_VALUE) ? -1 : second;
        }
    }
}



class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}