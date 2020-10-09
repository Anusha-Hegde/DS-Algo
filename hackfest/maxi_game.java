package hackfest;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


/*
Given an array of piles of stones (index i representing no. of stones in the pile), collect maximum stones with following conditions:

i1 + i3 + i5 + .... = i2 + i4 + 16 + ............

you can pick any number of stones from each pile

*/


public class maxi_game {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        
        int sum1 = 0, sum2 = 0;
        
        int i = 0, j = 1;
        
        while(i < n && j < n){
            sum1 += arr.get(i);
            sum2 += arr.get(j);
            i += 2;
            j += 2;
        }
        
        if(i < n) sum1 += arr.get(i);
        

        bufferedWriter.write(String.valueOf(Math.min(sum1, sum2) * 2));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
