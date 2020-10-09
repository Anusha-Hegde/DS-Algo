package reachScore;


public class reachScore2 {


    static int count(int n){ 
      
        int table[] = new int[n + 1], i; 
        
        table[0] = 1; 
      
        for (i = 3; i <= n; i++) 
            table[i] += table[i - 3]; 
        for (i = 5; i <= n; i++) 
            table[i] += table[i - 5]; 
        for (i = 10; i <= n; i++) 
            table[i] += table[i - 10]; 
      
        return table[n]; 
    } 
      
    public static void main (String[] args)  
    { 
        System.out.println("Count for 20 is "+count(20)); 
      
        System.out.println("Count for 13 is "+count(13)); 
    } 
}
