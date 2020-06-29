/**
 * _38_CountAndSay
 */
public class _38_CountAndSay {

    public String countAndSay(int n) {
        String desc = "1";
        StringBuilder stringBuilder;

        for (int i = 1; i < n; ++i) {
            stringBuilder = new StringBuilder();
            char[] chars = desc.toCharArray();
            int value = chars[0];
            int count = 1;
            for (int j = 0; j < chars.length; ++j) {
                if (j == chars.length - 1) {
                    stringBuilder.append(count).append(value);
                } else if (chars[j] == chars[j - 1]) {
                    count++;
                } else if (j != 0) {
                    stringBuilder.append(count).append(value);
                    count = 1;
                    value = chars[j];
                }
            }
            desc = stringBuilder.toString();
        }

        return desc;
    }
}