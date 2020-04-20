import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
}