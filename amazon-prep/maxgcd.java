
import java.util.*;

class maxgcd {


    public static void main(String args[] ) throws Exception {
        
    
        Scanner s = new Scanner(System.in).useDelimiter("\n");
        
        int tc = s.nextInt();


        while(tc-- > 0){

            Map<Integer, Set<Integer>> map = new HashMap<>();

            int n = s.nextInt();

            int[] arr = new int[n];

            String[] temp = s.next().split(" ");

            for(int i = 0 ; i < n; i++){
                arr[i] = Integer.parseInt(temp[i]);
            }

            for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    int g = gcd(arr[i], arr[j]);
                    if(g > 1){
                        Set<Integer> set = map.getOrDefault(g, new HashSet<>());
                        set.add(i);
                        set.add(j);
                        map.put(g, set);
                    }

                    else if(arr[i] == arr[j]) {
                        Set<Integer> set = map.getOrDefault(g, new HashSet<>());
                        set.add(i);
                        set.add(j);
                        map.put(g, set);
                    }
                    
                }
            }

            System.out.println(map);

            int res = 0;
            for(int i : map.keySet()){
                res = Math.max(res, map.get(i).size());
            }

            System.out.println(n - res);
        }

    }

    public static int gcd(int a, int b){
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        while(x >= 1){
            int c = y % x;
            y = x;
            x = c;
        }

        return y;
    }
}
