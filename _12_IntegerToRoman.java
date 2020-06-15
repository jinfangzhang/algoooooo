import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * _12_IntegerToRoma
 */
public class _12_IntegerToRoman {

    private static Map<Integer, String> map;
    private static List<Integer> sList = new ArrayList<>();

    static {
        sList.add(1000);
        sList.add(900);
        sList.add(500);
        sList.add(400);
        sList.add(100);
        sList.add(90);
        sList.add(50);
        sList.add(40);
        sList.add(10);
        sList.add(9);
        sList.add(5);
        sList.add(4);
        sList.add(1);


        map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }


    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int anchorP = 0;
        while (num != 0) {
            for (int i = anchorP; i < 13; ++i) {
                int integer = sList.get(i);
                if (integer <= num) {
                    stringBuilder.append(map.get(integer));
                    num -= integer;
                    anchorP = i;
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}