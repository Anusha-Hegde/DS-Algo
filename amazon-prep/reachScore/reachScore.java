package reachScore;
import java.util.*;


public class reachScore {

    static int res;
	
	public void dynamic(int num){
	    if(num == 0){
	        res++;
	        return;
	    }
        if(num >= 10) dynamic(num - 10);
	    if(num >= 5) dynamic(num - 5);
	    if(num >= 3) dynamic(num - 3);
	    
	}
	
	public static void main (String[] args) {
	    
    	Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
            
        reachScore obj = new reachScore();
        
        
        while(tests-- >0) {
            
            res = 0;
            int num = sc.nextInt();
            
    		if(num < 3) System.out.println(res);
    		else{
    		    obj.dynamic(num);
    		    System.out.println(res);
    		}
        }
	}
}
