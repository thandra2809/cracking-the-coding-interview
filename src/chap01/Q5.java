    package chap01;

public class Q5 {
    //Implement a method to perform basic string compression using the counts of
    //repeated characters. For example, the string aabcccccaaa would become
    //a2blc5a3. If the "compressed" string would not become smaller than the original
    //string, your method should return the original string.

    static String compress(String s) {
        if (s == null || s.isEmpty()) return s;

        char prev = s.charAt(0);
        int cnt = 1;
        StringBuffer sb = new StringBuffer();
        sb.append(prev);
        for (int i = 1; i < s.length(); ++i) {
            char curr = s.charAt(i);
            if (curr == prev) {
                ++cnt;
            } else {
                prev = curr;
                sb.append(cnt)
                  .append(curr);
                cnt = 1;
            }
        }
        sb.append(cnt);

        return sb.toString().length() >= s.length() ? s : sb.toString();
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("aabbcc"));
        System.out.println(compress("aaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(compress("abcdefg"));
        System.out.println(compress("a"));
    }
}
