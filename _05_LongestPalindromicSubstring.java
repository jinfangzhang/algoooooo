package SwordOffer;

/**
 * _05_LongestPalindromicSubstring
 */
public class _05_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.isEmpty())
            return s;

        int sLength = s.length();
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[sLength][sLength];
        char[] strChar = s.toCharArray();
        for (int i = sLength - 1; i >= 0; i--) {
            for (int j = i; j < sLength; j++) {
                if (strChar[i] == strChar[j]) {
                    if (j - i <= 2)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];

                    if (dp[i][j] && end - start < j - i) {
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}