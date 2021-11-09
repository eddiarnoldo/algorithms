package medium;

import java.util.Stack;

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
        Stack<String> strings = new Stack<>();
        Stack<Integer> multipliers = new Stack<>();
        int idx = 0;
        String res = "";

        int multiplier = 0;
        while (idx < s.length()) {
            char currChar = s.charAt(idx);
            if (Character.isDigit(currChar)) {
                int numericValue = Character.getNumericValue(currChar);
                multiplier = (multiplier * 10) + numericValue;
            } else if (currChar == '[') {
                multipliers.push(multiplier);
                strings.push(res);
                multiplier = 0;
                res = "";
            } else if (currChar == ']') {
                StringBuilder tmp = new StringBuilder(strings.pop());
                int times = multipliers.pop();

                for (int i = 0; i < times; i++) {
                    tmp.append(res);
                }
                res = tmp.toString();
            } else {
                res += currChar;
            }
            idx++;
        }
        return res;
    }

}
