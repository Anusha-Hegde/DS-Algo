import java.util.*;

public class run {
    public static void main(String...s) {
        LargestItemAssociation a = new LargestItemAssociation();
        List<PairString> pairs = new ArrayList<>();
        pairs.add(new PairString("item1","item2"));
        pairs.add(new PairString("item3","item4"));
        pairs.add(new PairString("item4","item5"));
        System.out.println(a.largestItemAssociation(pairs));
    }
}
