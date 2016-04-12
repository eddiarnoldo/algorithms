import java.util.Arrays;

/**
 * Created by equintana on 4/12/16.
 */
public class AnagramAlgorithm {
    public static void main(String[] args) {
        System.out.println(areAnagrams("mary", "army"));
        System.out.println(areAnagramsUsingCharArray("mary", "army"));
    }


    public static boolean areAnagrams(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }

        char[] firstWordLetters = firstWord.toCharArray();
        char[] secondWordLetters = secondWord.toCharArray();

        Arrays.sort(firstWordLetters);
        Arrays.sort(secondWordLetters);

        String letters1 = new String(firstWordLetters);
        String letters2 = new String(secondWordLetters);

        return letters1.equals(letters2);
    }

    public static boolean areAnagramsUsingCharArray(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }
        int[] charMap = new int[256]; //Ascii characters length

        for (int i = 0; i < firstWord.length(); i++) {
            char c1 = firstWord.charAt(i);
            charMap[c1]++; //Every char has a decimal value from 0-255
            char c2 = secondWord.charAt(i);
            charMap[c2]--;
        }
        for (int i = 0; i < charMap.length; i++) {
            //Basically if both words have same letters the charMap values will be 0
            if (charMap[i] != 0) return false;
        }
        return true;

    }

}
