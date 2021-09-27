package easy;

/**
 * Input: x = 123
 * Output: 321
 * <p>
 * Input: x = -123
 * Output: -321
 * <p>
 * Input: x = 120
 * Output: 21
 */


public class ReverseInteger {

    public static void main(String[] args) {
        //Use String
        System.out.println(reverse(123));
        System.out.println(reverse(1534236469));
        //Pop approach
        System.out.println(reversePop(1534236469));

    }

    //3 ms, faster than 24.60%
    public static int reverse(int x) {
        final String strInt = Integer.toString(x);
        StringBuilder reverseInt = new StringBuilder();
        boolean negative = strInt.charAt(0) == '-';

        for (int i = strInt.length() - 1; negative ? i >= 1 : i >= 0; i--) {
            reverseInt.append(strInt.charAt(i));
        }

        double res = Double.parseDouble(reverseInt.toString()) * (negative ? -1 : 1);

        if (res > Math.pow(2, 31) || res < Math.pow(-2, 31)) {
            return 0;
        }
        return (int) res;
    }

    //Runtime: 1 ms, faster than 100.00%
    public static int reversePop(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //Max = 2147483648
            //Min = 2147483647
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;

        }

        return rev;
    }

}
