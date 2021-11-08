package medium;

import java.util.Stack;
import java.util.stream.Stream;

public class DecodeString {

    /*
        Receive a string like:
         - "5[a]2[b]" -> aaaaabb
         - "2[3[c]2[t]]" -> cccttccctt
     */

    public static void main(String[] args) {
        System.out.println(decode("y2[w2[cx3[a]]]"));
        System.out.println(decode("2[3[c]2[t]]"));
        System.out.println(decode("3[a2[c]]"));
    }

    public static String decode(String s) {
        Stack<String> results = new Stack<>();
        Stack<Integer> multipliers = new Stack<>();
        String res = "";
        int idx = 0;
        int length = s.length();

        while (idx < length) {
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;
                multipliers.push(num);
                while (Character.isDigit(s.charAt(idx))) {
                    num = multipliers.pop();
                    num = num * 10 + (s.charAt(idx) - '0');
                    multipliers.push(num);
                    idx++;
                }
            } else if (s.charAt(idx) == '[') {
                results.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(results.pop());
                int count = multipliers.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx);
                idx++;
            }
        }

        return res;
    }

}
