package NoOfIslands;


import java.util.LinkedList;
import java.util.Queue;

class BFS {

    int no = 0, i2, j2;
    int[] temp;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    no++;
                }
            }
        }
        return no;
    }

    public void bfs(char[][] grid, int i, int j) {

        Queue<int[]> q = new LinkedList<>();

        temp = new int[]{i, j};
        q.add(temp);


        while (!q.isEmpty()) {
            
            temp = q.poll();
            i = temp[0];
            j = temp[1];

            grid[i][j] = '0';
            
            //---------------------------------------------
            
            i2 = i + 1;
            j2 = j;

            if(i2 < grid.length && grid[i2][j2] != '0'){
                temp = new int[]{i2, j2};
                q.add(temp);
            }
            
            //---------------------------------------------
            
            i2 = i - 1;
            j2 = j;

            if(i2 >= 0 && grid[i2][j2] != '0'){
                temp = new int[]{i2, j2};
                q.add(temp);
            }
            
            //---------------------------------------------
            
            i2 = i;
            j2 = j + 1;

            if(j2 < grid[i2].length && grid[i2][j2] != '0'){
                temp = new int[]{i2, j2};
                q.add(temp);
            }
            
            //---------------------------------------------
            
            i2 = i;
            j2 = j - 1;

            if(j2 >= 0 && grid[i2][j2] != '0'){
                temp = new int[]{i2, j2};
                q.add(temp);
            }  

        }
    }
}
