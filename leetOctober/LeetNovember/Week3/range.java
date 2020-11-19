import java.util.*;

class range {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int i = 0;
        int[][] res = new int[intervals.length][2];
        int count = 0;
        while(i < intervals.length){
            int j = i;
            int temp = intervals[i][1];
            while(i < intervals.length - 1 && temp >= intervals[i + 1][0]){
                i++;
                temp = Math.max(intervals[i][1], temp);
            }
            res[count][0] = intervals[j][0];
            res[count][1] = temp;
            count++;
            i++;
        }
        return Arrays.copyOfRange(res, 0, count);
    }
}