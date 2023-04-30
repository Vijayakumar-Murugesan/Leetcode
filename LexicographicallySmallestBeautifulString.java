/*
2663. Lexicographically Smallest Beautiful String

A string is beautiful if:

It consists of the first k letters of the English lowercase alphabet.
It does not contain any substring of length 2 or more which is a palindrome.
You are given a beautiful string s of length n and a positive integer k.

Return the lexicographically smallest string of length n, which is larger than s and is beautiful. If there is no such string, return an empty string.

A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b.

For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character, and d is greater than c.
 */
public class LexicographicallySmallestBeautifulString {
    public static void main(String[] args) {
        String s1 = "abcde";
        int k1 = 3;
        String result1 = smallestBeautifulString(s1, k1);
        System.out.println(result1); // Expected output: "aba"

        String s2 = "abbcddef";
        int k2 = 5;
        String result2 = smallestBeautifulString(s2, k2);
        System.out.println(result2); // Expected output: "aabbc"

        String s3 = "abcz";
        int k3 = 26;
        String result3 = smallestBeautifulString(s3, k3);
        System.out.println(result3); // Expected output: "abda"

        String s4 = "dc";
        int k4 = 4;
        String result4 = smallestBeautifulString(s4, k4);
        System.out.println(result4); // Expected output: ""
    }

    public static String smallestBeautifulString(String s, int k) {
        int n = s.length();
        int[] c = new int[n];
        for (int i = 0; i < n; i++)
            c[i] = s.charAt(i) - 'a';
        for (int i = n-1; i >= 0; i--) {
            for (int l = c[i]+1; l < k; l++)
                if (good(c, i, l)) {
                    c[i] = l;
                    for (int j = i+1; j < n; j++)
                        for (int m = 0; m < k; m++)
                            if (good(c, j, m)) {
                                c[j] = m;
                                break;
                            }
                    StringBuffer sb = new StringBuffer();
                    for (int j = 0; j < n; j++)
                        sb.append((char)('a' + c[j]));
                    return sb.toString();
                }
        }
        return "";
    }

    public static boolean good(int[] c, int i, int val) {
        if (i >= 1 && c[i-1] == val)
            return false;
        if (i >= 2 && c[i-2] == c[i-1] && c[i-1] == val)
            return false;
        return true;
    }
}
