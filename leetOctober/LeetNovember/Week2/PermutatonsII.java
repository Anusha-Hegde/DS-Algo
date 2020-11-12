package leetOctober.LeetNovember.Week2;

import java.util.*;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order. 
 * 
 * Example 1:
 *  Input: nums = [1,1,2] 
 *  Output: [[1,1,2], [1,2,1], [2,1,1]]
 * 
 */

public class PermutatonsII {
    
    int l;
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    boolean[] bool;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        l = nums.length;
        bool = new boolean[l];
        Arrays.sort(nums);
        this.nums = nums;
        dynamic(new ArrayList<>());
        return res;
    }

    private void dynamic(List<Integer> temp){
        if(temp.size() == l){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(bool[i] || (i > 0 && nums[i] == nums[i - 1]) && !bool[i - 1]) continue;
            bool[i] = true;
            temp.add(nums[i]);
            dynamic(temp);
            temp.remove(temp.size() - 1);
            bool[i] = false;
        }
    }
}
