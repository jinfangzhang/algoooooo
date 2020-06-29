/**
 * _28_ImplementsStrStr
 */
public class _28_ImplementsStrStr {

    public int strStr(String haystack, String needle) {
        return getIndexOf(haystack, needle);
    }

    public int getIndexOf(String str, String match) {
        if (str == null || match == null || str.length() < 1 || match.length() < 1 || str.length() < match.length())
            return 0;

        char[] ss = str.toCharArray();
        char[] ms = match.toCharArray();
        int si = 0;
        int mi = 0;

        int[] next = getNextArray(ms);

        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public int[] getNextArray(char[] ms) {
        if (ms.length == 1)
            return new int[]{-1};

        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn])
                next[pos++] = ++cn;
            else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}