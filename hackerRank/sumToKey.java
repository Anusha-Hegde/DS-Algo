
package hackerRank;

import java.util.*;


public class sumToKey {

    static int[] table;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n = sc.nextInt();

        sc.close();

        table = new int[n + 1];
        table[0] = 1;

        sumKey(n);

        System.out.println(table[n]);
    }

    public static void sumKey(int n){

        for(int i = 3; i <= n; i++){
            table[i] += table[i - 3];
        }
        for(int i = 5; i <= n; i++){
            table[i] += table[i - 5];
        }
        for(int i = 10; i <= n; i++){
            table[i] += table[i - 10];
        }
    }
}
