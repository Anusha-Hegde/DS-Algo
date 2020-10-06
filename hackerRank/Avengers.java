package hackerRank;

import java.util.*;

/*

Given an Array, find if it is a palindrome after performing the following operations atleat once:

--> add 2 adjacent numbers to form one single number.

If it can form a palindrome return the number of operations needed.

if it cannot form a palindrome after above operations return 0;

*/

public class Avengers {

    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Enter array length");
        int n = sc.nextInt();

        arr = new int[n];

        System.out.println("Enter the array elements");
        String num = sc.next();

        sc.close();

        int count = 0;
        for (String i : num.split(" "))
            arr[count++] = Integer.parseInt(i);

        int flag = 0;

        System.out.println(palindrome(0, arr.length - 1, flag));

    }

    public static int palindrome(int i, int j, int flag) {

        if (i == j)
            return flag;

        if (arr[i] == arr[j]) {
            if (j - i == 1)
                return flag;
            return palindrome(i + 1, j - 1, flag);
        }

        if (arr[i] + arr[i + 1] == arr[j]) {
            if (j - i == 2)
                return flag + 1;
            return palindrome(i + 2, j - 1, flag + 1);
        }

        if (arr[i] == arr[j - 1] + arr[j]) {
            if (j - i == 2)
                return flag + 1;
            return palindrome(i + 1, j - 2, flag + 1);
        }

        if (arr[i] + arr[i + 1] == arr[j - 1] + arr[j]) {
            if (j - i == 3)
                return flag + 2;
            return palindrome(i + 2, j - 2, flag + 2);
        }

        return flag;
    }

}
