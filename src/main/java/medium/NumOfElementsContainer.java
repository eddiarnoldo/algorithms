package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Uses dynamic programming
 * "|**|**|*"
 *
 * Generates an array[n]
 * [0,0,0,2,2,2,4,4]
 *
 * And then we ask for the diff of end index and start, e.g index {2, 6} => "*|**|"
 * array[2] => 0
 * array[6] => 4
 */
public class NumOfElementsContainer {
    public static void main(String[] args) {
        List<Integer> startIndices = Arrays.asList(1,3);
        List<Integer> endIndices = Arrays.asList(2,7);
        getNumElements("|**|**|*", startIndices, endIndices).forEach(System.out::println);
    }

    public static List<Integer> getNumElements(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> result = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) != '|') i++;

        int[] dp = new int[n];
        int count = 0;
        i++;
        while (i < n) {
            if (s.charAt(i) == '|') {
                dp[i] = dp[i - 1] + count;
                count = 0;
            } else {
                dp[i] = dp[i - 1];
                count++;
            }
            i++;
        }


        for (int x = 0; x < startIndices.size(); x++) {
            int startIdxModifier = 0;
            int endIdxModifier = 0;
            while((s.charAt(endIndices.get(x)-1-endIdxModifier)) != '|') endIdxModifier++;
            while((s.charAt(startIndices.get(x)-1+startIdxModifier)) != '|') startIdxModifier++;

            result.add(dp[endIndices.get(x)-1-endIdxModifier] - dp[startIndices.get(x)-1+startIdxModifier]);
        }

        return result;
    }
}
