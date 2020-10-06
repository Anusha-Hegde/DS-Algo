package hackerRank;

import java.util.*;


/*

Given an Array, find if it is a palindrome after performing the following operations atleat once:

--> add 2 adjacent numbers to form one single number.

If it can form a palindrome return the number of operations needed.

if it cannot form a palindrome after above operations return 0;

*/

public class Avengers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Enter array length");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements");
        String num = sc.next();

        sc.close();

        int count = 0;
        for(String i : num.split(" ")) arr[count++] = Integer.parseInt(i);

        int flag = 0;

        System.out.println(palindrome(arr, n, flag));

    }

    public static int palindrome(int[] arr, int n, int flag){

        if(n == 0 || n == 1) return flag;

        if(arr[0] == arr[n - 1]){
            if(arr.length == 2) return flag;
            return palindrome(Arrays.copyOfRange(arr, 1, n - 1), n - 2, flag);
        }

        if(arr[0] + arr[1] == arr[n - 1]){
            if(arr.length == 3) return flag + 1;
            return palindrome(Arrays.copyOfRange(arr, 2, n - 1), n - 3, flag + 1);
        }

        if(arr[0] == arr[n - 1] + arr[n - 2]){
            if(arr.length == 3) return flag + 1;
            return palindrome(Arrays.copyOfRange(arr, 1, n - 2), n - 3, flag + 1);
        }

        if(arr[0] + arr[1] == arr[n - 1] + arr[n - 2]){
            if(arr.length == 4) return flag + 2;
            return palindrome(Arrays.copyOfRange(arr, 2, n - 2), n - 4, flag + 2);
        }

        return flag;
    } 
}
