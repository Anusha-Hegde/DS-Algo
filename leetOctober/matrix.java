package leetOctober;

public class matrix {
    class Solution {
    
        int[][] arr;
        int target;
        int n, m;
        
        public boolean searchMatrix(int[][] matrix, int target) {
            arr = matrix;
            m = matrix.length;
            if(m == 0) return false;
            n = matrix[0].length;
            if(n == 1 && m == 1) return matrix[0][0] == target;
            this.target = target;
            return binS(1, m * n);
        }
        public boolean binS(int start, int end){
            
            if(end < start) return false;
            
            int mid;
            if(end == start) mid = start;
            else mid = (end + start - 1) / 2; 
            
            int i = mid / n;
            int j = (mid % n);
            if(j == 0){
                j = n;
                i--;
            }
            
            j--;
            
            // System.out.println(arr[i][j]);
            
            if(arr[i][j] == target) return true;
            
            else if(arr[i][j] < target) return binS(mid + 1, end);
            
            return binS(start, mid - 1);
            
        }
    }
}
