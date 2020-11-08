public class check {
    static int res = 0;

    public static int solve(int[] A, int[] B) {
        int res = 0;
        int len = A.length;
        int i;
        int count = 0;
        while (count < len) {
            for(int j : A) System.out.print(j + " ");
            System.out.println();
            i = len - count - 1;
            while (A[i] != (len - count)){
                System.out.println(i);
                i--;
            }
            int temp = i;
            int temp2 = 0;
            while (temp < len - count - 1) {
                A[temp] = A[temp + 1];
                temp++;
                temp2++;
            }
            // if (temp2 > B[temp])
            //     return -1;
            A[temp] = len - count;
            res += temp2;
            count++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] A = { 1, 3, 4, 2, 5, 10, 7, 9, 15, 12, 6, 11, 17, 19, 8, 13, 14, 18, 16 };
        int[] B = { 2, 6, 5, 3, 1, 10, 8, 4, 8, 3, 7 };
        solve(A, B);
    }
}