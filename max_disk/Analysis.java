package max_disk;

import java.util.*;

public class Analysis {
    public int solution(List<Integer> hardDiskSpace, int segmentLength){
        int ans = 0;
        int i = 0;
        while(i < hardDiskSpace.size() - segmentLength + 1){
            int lmin = 2147483647;
            for(int j = 0; j < segmentLength; j++){
                if(hardDiskSpace.get(i + j) < lmin) lmin = hardDiskSpace.get(i + j);
            }
            System.out.println(lmin);
            if(lmin > ans) ans = lmin;
            i++;
        }
        return ans;
    }
}
