import java.util.ArrayList;
import java.util.List;

/**
 * _06_ZigZagConversion
 */
public class _06_ZigZagConversion {

     /**
     * 将一个给定字符串根据给定的行号、以从上往下，从左到右进行 Z 字形排列
     */
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;

        List<StringBuilder> row = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; ++i) row.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            row.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : row) res.append(stringBuilder);
        return res.toString();
    }
}