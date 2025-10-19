import java.util.*;

public class LongestSubstringKUnique {
    public static int longestkSubstr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, res = -1;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }
            if (map.size() == k) res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe", 3));
    }
}
