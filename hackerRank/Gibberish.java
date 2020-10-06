package hackerRank;

import java.util.Scanner;
import java.util.*;

/*
Given a String dictionary (set of elements in dictionry), and a word, check if the word is meaningful or not

Example:

dict = "ab bc ca"
word = "abca"
output = 1

dict = "ab ff bc"
word = "abfbc"
output = 0

*/

class Gibberish {

    static Set<String> set;

    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int t = sc.nextInt();

        while(t-- > 0){

            set = new HashSet<String>();

            String s = sc.next();

            String word = sc.next();

            for(String k : s.split(" ")){
                set.add(k);
            }

            if(dfs(word)) System.out.println(1);
            else System.out.println(0);
        }

        sc.close();

    }

    public static boolean dfs(String word){
        if(word.length() == 0) return true;
        for(int i = 1; i <= word.length(); i++){
            if(set.contains(word.substring(0, i))){
                if(i < word.length()) return dfs(word.substring(i)); 
                else return true;
            }
        }
        return false;
    }
}
