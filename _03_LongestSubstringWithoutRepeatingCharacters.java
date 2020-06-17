import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * _03_LongestSubstringWithoutRepeatingCharacters
 */
public class _03_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Deque<Character> queue = new ArrayDeque<>();
        char[] cArr = s.toCharArray();
        for (char c : cArr) {
            if(queue.contains(c)) 
                while(c != queue.removeLast());
                
            queue.addFirst(c);
            max = Math.max(max, queue.size());
        }

        return max;
    }

    public int lengthOfLongestSubstring_2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstringDp(String s) {
        int max = 0;
        int[] dp = new int[s.length() + 1];
        Map<Character, Integer> map = new HashMap<>();

        char[] cArr = s.toCharArray();
        for(int i = 1; i <= s.length(); ++i)  {
            if(map.containsKey(cArr[i - 1])) {
                int lastIndex = map.get(cArr[i - 1]);
                if(i - dp[i - 1] > lastIndex) {
                    dp[i] = dp[i -1] + 1;
                } else {
                    dp[i] = i - lastIndex;
                }
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            map.put(cArr[i - 1], i);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int lengthOfLongestSubstring_3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}