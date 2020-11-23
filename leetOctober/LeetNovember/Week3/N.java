import java.util.*;


/**
 * 
 * Given an array of digits, you can write numbers using each digits[i] as many times as we want.  For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.

Return the number of positive integers that can be generated that are less than or equal to a given integer n.
 */

public class N {
    public int atMostNGivenDigitSet(String[] digits, int num) {
        
        int l = digits.length;

        Arrays.sort(digits);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, res, t = 0, flag = 1, i;

        for(i = 0; i < 10 && count < l; i++){
            map.put(i, count);
            if(Integer.parseInt(digits[count]) == i) count++;
        }
        while(i < 11) map.put(i++, count);
        
        String n = Integer.toString(num);
        
        res = -1;
        
        
        int temp = (int)Math.pow(l, n.length() - 1);
        for(char j : n.toCharArray()){
            res += temp;
            num = j - '0';
            if(!(t == 1 && map.get(num) == 1) && flag == 1) t += map.get(num) * temp;
            if(map.get(num) == map.get(num + 1)) flag = 0;
            temp /= l;
        }
        System.out.println(res + " and " + t + "and" + flag);
        
        return res + t + flag;
    }
}
