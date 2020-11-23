/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

 * 
 */

public class RotatedSortedArray {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int n = r;
        if(n == -1) return false;
        if(nums[r] == target || nums[l] == target) return true;
        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] == target) return true;
            if(nums[m] < nums[r] || nums[m] < nums[l]){
                if(nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
            else if(nums[m] > nums[l] || nums[m] > nums[r]){
                if(nums[m] > target && target >= nums[l]) r = m - 1;
                else l = m + 1;
            }
            else r--;
        }
        return false;
    }
}
