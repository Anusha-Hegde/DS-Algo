package leetOctober.LeetNovember.Week4;

import java.util.Stack;

public class Calculator {
    public int calculate(String s) {
        
        int num = 0;
        char sign = '+';
        int l = s.length();
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < l; i++){
            if(Character.isDigit(s.charAt(i))) num = num * 10 + s.charAt(i) - '0';
            if((' ' != s.charAt(i) && !Character.isDigit(s.charAt(i))) || i == l - 1){
                if(sign == '-') st.push(-num);
                if(sign == '+') st.push(num);
                if(sign == '*') st.push(st.pop() * num);
                if(sign == '/') st.push(st.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }            
        }
        while(!st.isEmpty()) num += st.pop();
        return num;
    }
    
}
