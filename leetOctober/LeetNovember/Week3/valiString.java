public class valiString {
    public String decodeString(String s) {
        return meth(s, 1);
    }
    public String meth(String s, int n){
        String real_res = "";
        String res = "";
        
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) res += s.charAt(i);
            else{
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                int count = 1;
                i++;
                String temp = "";
                while(true){
                    if(s.charAt(i) == '[') count++;
                    if(s.charAt(i) == ']') count--;
                    if(count == 0) break;
                    temp += s.charAt(i);
                    i++;
                }
                res += meth(temp, num);
            }
        }
        
        while(n-- > 0) real_res += res;
        return real_res;
    }
}
