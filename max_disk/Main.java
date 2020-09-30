package max_disk;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Analysis obj = new Analysis();
        List<Integer> hardDiskSpace = new ArrayList<Integer>(Arrays.asList(8, 5, 4));
        int segmentLength = 2;
        System.out.println("Ans = "+obj.solution(hardDiskSpace, segmentLength));
    }
}
