package easy;

import java.util.Stack;

public class AddString {
    public static void main(String[] args) {
        System.out.println(addStrings("6994", "36"));
    }

    //Refactor!!
    //6994, 36
    public static String addStrings(String num1, String num2) {
        int firstNumSizeIdx = num1.length() - 1;
        int secondNumSizeIdx = num2.length() - 1;
        Stack<Integer> digits = new Stack<>();
        int carry = 0;

        while (true) {
            if (firstNumSizeIdx < 0 && secondNumSizeIdx < 0) {
                break;
            }

            if (firstNumSizeIdx >= 0 && secondNumSizeIdx >= 0) {
                int firstDigit = num1.charAt(firstNumSizeIdx) - '0';
                int secondDigit = num2.charAt(secondNumSizeIdx) - '0';
                int total = carry + firstDigit + secondDigit;

                if (total >= 10) {
                    carry = 1;
                    total = total % 10;
                } else {
                    carry = 0;
                }
                digits.push(total);
            } else {
                if (firstNumSizeIdx < 0) {
                    int item = num2.charAt(secondNumSizeIdx) - '0' + carry;
                    carry = item / 10;
                    item = item % 10;
                    digits.push(item);

                } else {
                    int item = num1.charAt(firstNumSizeIdx) - '0' + carry;
                    carry = item / 10;
                    item = item % 10;
                    digits.push(item);
                }
            }

            firstNumSizeIdx--;
            secondNumSizeIdx--;
        }
        if (carry != 0) {
            digits.push(carry);
        }


        StringBuilder res = new StringBuilder();
        while (!digits.isEmpty()) {
            res.append(digits.pop());
        }

        return res.toString();
    }
}
