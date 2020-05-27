package SwordOffer;

/**
 * _03_ReplaceSpace
 */
public class _03_ReplaceSpace {

    public static String replaceSpace(String s) {
        if (s == null || s.isEmpty())
            return "";

        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            if(aChar == ' ')
                sb.append("%20");
            else
                sb.append(aChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are Family";
        System.out.println(replaceSpace(s));
    }
}