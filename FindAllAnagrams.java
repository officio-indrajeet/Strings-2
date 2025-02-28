
//Time complexity : O(m)
//Space complexity : O(n)
import java.util.*;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);

    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n)
            return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int cnt = map.get(in) - 1;
                map.put(in, cnt);
                if (cnt == 0) {
                    match++;
                }
            }
            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    int cnt = map.get(out) + 1;
                    map.put(out, cnt);
                    if (cnt == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

}
