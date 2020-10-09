// package Maximum_Units;
import java.util.*;

public class MaximumUnits {
    public long getMaxUnit(ArrayList<Integer> boxes, ArrayList<Integer> unitsPerBox, long truckSize){

        long res = 0;

        while(truckSize > 0){

            int index = unitsPerBox.indexOf(Collections.max(unitsPerBox));

            if(boxes.get(index) < truckSize){
                res += boxes.get(index) * unitsPerBox.get(index);
                truckSize -= boxes.get(index);
            }

            else{
                res += truckSize * unitsPerBox.get(index);
                truckSize = 0;
                break;
            }

            boxes.remove(index);
            unitsPerBox.remove(index);
        }
        return res;
    }
}
