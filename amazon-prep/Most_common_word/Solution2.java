package Most_common_word;

import java.util.*;

public class Solution2 {
    public String mostCommonWord(String paragraph, String[] ban) {

        Set<Character> puncts = new HashSet<>();
        Collections.addAll(puncts, '!', '?', '\'', ';', '.', ' ', ',');

        Set<String> banned = new HashSet<>(Arrays.asList(ban));
        String res = "", word = "";
        int max = 0;

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (Character i : paragraph.toCharArray()) {
            if (!puncts.contains(i)) {
                i = Character.toLowerCase(i);
                word += i;
            } else {
                if (!banned.contains(word) && word.length() > 0) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
                word = "";
            }

        }

        if (!banned.contains(word) && word.length() > 0) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                res = i;
            }
        }
        return res;
    }
}
