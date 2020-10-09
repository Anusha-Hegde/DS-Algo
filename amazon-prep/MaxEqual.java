import java.util.*;

public class MaxEqual {
    public int findMaxLength(int[] nums) {
        
        int res = 0, sum = 0, curr;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) nums[i] = -1;
            sum += nums[i];
            if(map.containsKey(sum)){
                curr = i - map.get(sum);
                res = Math.max(res, curr);
            }
            else map.put(sum, i);
        }
        
        return res;
        
    }
}
