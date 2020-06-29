import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * _30_FindSubString
 */
public class _30_FindSubString {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        if (words.length <= 0)
            return res;

        int allWordSum = 0;
        int wordLen = words[0].length();
        Map<String, Integer> backupMap = new HashMap<>();
        for (String word : words) {
            allWordSum += word.length();
            if (!backupMap.containsKey(word)) {
                backupMap.put(word, 0);
            }
            backupMap.put(word, backupMap.get(word) + 1);
        }

        if (allWordSum > s.length())
            return res;

        int last = s.length() - allWordSum;
        for (int i = 0; i <= last; ++i) {
            Map<String, Integer> map = new HashMap<>();
            for (Map.Entry<String, Integer> entry : backupMap.entrySet())
                map.put(entry.getKey(), entry.getValue());

            int j = i;
            while (j <= s.length() - wordLen) {
                String subString = s.substring(j, j + wordLen);
                if (map.containsKey(subString)) {
                    j += wordLen;
                    if (map.get(subString) == 1)
                        map.remove(subString);
                    else
                        map.put(subString, map.get(subString) - 1);
                } else
                    break;
            }

            if (map.isEmpty())
                res.add(i);
        }
        return res;
    }

    public List<Integer> findSubstring123ms(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        //HashMap1 存所有单词
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //遍历所有子串
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            //判断该子串是否符合
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断该单词在 HashMap1 中
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }
}