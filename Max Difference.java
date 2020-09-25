/*

    Pick a digit x (0 <= x <= 9).
    Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
    Replace all the occurrences of x in the decimal representation of num by y.
    The new integer cannot have any leading zeros, also the new integer cannot be 0.

Let a and b be the results of applying the operations to num the first and second times, respectively.

Return the max difference between a and b.
*/


class Solution {
    public int maxDiff(int num) {
        String a = Integer.toString(num);
        String b = Integer.toString(num);
        char rep;
        rep = a.charAt(0);
        for(char c : a.toCharArray()){
            if(c != '9'){
                rep = c;
                break;
            }
        }
        
        a = a.replace(rep, '9');
        int resa = Integer.parseInt(a);
        
        rep = b.charAt(0);
        for(char c : b.toCharArray()){
            if(c != '1' && c != '0'){
                rep = c;
                break;
                }
            }
        if(rep == b.charAt(0)) b = b.replace(rep, '1');
        else b = b.replace(rep, '0');
        
        int resb = Integer.parseInt(b);
        return (resa - resb);
    }
}
