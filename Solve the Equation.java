/*
Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution". If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

*/


class Solution {
    public int tcon, tvar, con = 0 , var = 0;
     
    
    public void evaluate(String s){
        
        tcon = 0;
        tvar = 0;
        
        String[] parts = s.split("(?=[-+])");
        for(String temp : parts){
            if(temp.equals("+x") || temp.equals("x")) tvar += 1;
            else if(temp.equals("-x")) tvar -= 1;
            else if(temp.contains("x")) tvar += Integer.parseInt(temp.substring(0, temp.indexOf('x')));
            else tcon += Integer.parseInt(temp);
        }
    }
    
    
    
    public String solveEquation(String equation) {
        
        //LHS
        evaluate(equation.split("=")[0]);
        con -= tcon;
        var += tvar;
        
        //RHS
        evaluate(equation.split("=")[1]);
        con += tcon;
        var -= tvar;
        
        
        if(con == 0 && var == 0) return "Infinite solutions";
        if(var == 0) return "No solution";
        return("x=" + con/var);
    }
}
