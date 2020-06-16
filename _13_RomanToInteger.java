import java.util.HashMap;
import java.util.Map;

/**
 * _13_RomanToInteger
 */
public class _13_RomanToInteger {

    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int size = chars.length;
        int i = 0;
        while (i < size) {
            char c = chars[i];
            switch (c) {
                case 'I':
                    if (i + 1 < size && chars[i + 1] == 'V') {
                        sum += 4;
                        i += 2;
                    } else if (i + 1 < size && chars[i + 1] == 'X') {
                        sum += 9;
                        i += 2;
                    } else {
                        sum += 1;
                        i++;
                    }
                    break;
                case 'V':
                    sum += 5;
                    i++;
                    break;
                case 'X':
                    if (i + 1 < size && chars[i + 1] == 'L') {
                        sum += 40;
                        i += 2;
                    } else if (i + 1 < size && chars[i + 1] == 'C') {
                        sum += 90;
                        i += 2;
                    } else {
                        sum += 10;
                        i += 1;
                    }
                    break;
                case 'L':
                    sum += 50;
                    i += 1;
                    break;
                case 'C':
                    if (i + 1 < size && chars[i + 1] == 'D') {
                        sum += 400;
                        i += 2;
                    } else if (i + 1 < size && chars[i + 1] == 'M') {
                        sum += 900;
                        i += 2;
                    } else {
                        sum += 100;
                        i++;
                    }
                    break;
                case 'D':
                    sum += 500;
                    i += 1;
                    break;
                case 'M':
                    sum += 1000;
                    i += 1;
                    break;
            }
        }
        return sum;
    }

    private static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public int romanToInt2(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (i + 1 < chars.length && map.containsKey(s.substring(i, i + 2))) {
                sum = sum + map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                sum = sum + map.get(s.substring(i, i + 1));
                i += 1;
            }
        }

        return sum;
    }
}