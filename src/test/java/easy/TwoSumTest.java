package easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TwoSumTest {

    @Test
    public void testFailure() {
        TwoSum sum = new TwoSum();
        int[] values = new int[]{3,2,4};

        int[] solution = sum.twoSum(values, 6);
        Assertions.assertEquals(1, solution[0]);
        Assertions.assertEquals(2, solution[1]);

        int[] solution2 = sum.twoSumLessMemory(values, 6);
        Assertions.assertEquals(2, solution2[0]);
        Assertions.assertEquals(1, solution2[1]);
    }
}