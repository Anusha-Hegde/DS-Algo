/*
A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

    0 <= i <= s.length - 2
    s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.

To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.
*/


class Solution {
    public String makeGood(String s) {
        int i = 0;
        while(true){
            if(i >= s.length() - 1) break;
            if((Character.isLowerCase(s.charAt(i)) && Character.isUpperCase(s.charAt(i + 1))) || (Character.isUpperCase(s.charAt(i)) && Character.isLowerCase(s.charAt(i + 1)))){
                if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i + 1))){
                    s = s.substring(0, i) + s.substring(i + 2); 
                    i = 0;
                    continue;
                }
            }
            i += 1;
            
        }
        return s;
    }
}
