package easy;

public class Permutations {
    public static void main(String[] args) {
        System.out.println("cas".substring(0,2));
        permutations("cas");
    }

    static void permutations(String str) {
        permutations(str, "");
    }

    private static void permutations(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutations(rem, prefix + str.charAt(i));
            }
        }
    }


}
