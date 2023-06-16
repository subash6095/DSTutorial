package src.main.java.strings;

public class LongestPalindromicSubstring {
    private int lo, maxLen;

    public String longestPalindromicSubstring(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
        String inputStr = "babad";
        String result = palindromicSubstring.longestPalindromicSubstring(inputStr);
        System.out.println(result); // Output: "bab"
    }

    //code Reference : https://leetcode.com/problems/longest-palindromic-substring/solutions/2928/very-simple-clean-java-solution/
    //Explanation : https://leetcode.com/problems/palindromic-substrings/solutions/105688/Very-Simple-Java-Solution-with-Detail-Explanation/
}
