package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    /*
    Solution explanation:
    O(2n)

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Input: nums = [3,3], target = 6
    Output: [0,1]

     * Run time: O(2n) -> O(n)
     * Space complexity: O(n)

     */
    public int[] twoSum(int[] nums, int target) {
        //Hash Initialize
        Map<Integer, Integer> deltas = new HashMap<>();
        int firstIdx = 0;
        int secondIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            deltas.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            firstIdx = i;
            int missing = target - nums[i];
            if (deltas.containsKey(missing)) {
                secondIdx = deltas.get(missing);
                if (secondIdx == firstIdx) {
                    continue;
                }
                break;
            }
        }

        return new int[]{firstIdx, secondIdx};
    }

    /*
     * This solution takes less memory as it searches for the solution at the same time that we increase the deltas
     * Run time: O(n) - Even that this is still an O(n) it performs faster than the previous approach
     * Space complexity: O(n)
     */
    public int[] twoSumLessMemory(int[] nums, int target) {
        int remaining;
        Map<Integer, Integer> deltas = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            remaining = target - nums[i];
            if (deltas.containsKey(remaining)) {
                return new int[]{i, deltas.get(remaining)};
            }
            deltas.put(nums[i], i);
        }

        return new int[]{0, 0};
    }
}