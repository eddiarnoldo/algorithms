package easy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicates {
    public static void main(String[] args) {
        final int[] nums1 = {};
        printResult(removeDuplicates(nums1), nums1);

        final int[] nums2 = {0};
        printResult(removeDuplicates(nums2), nums2);

        final int[] nums3 = {1, 1};
        printResult(removeDuplicates(nums3), nums3);

        final int[] nums4 = {1, 2};
        printResult(removeDuplicates(nums4), nums4);

        final int[] nums8 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //printResult(removeDuplicates(nums5), nums5);
        printResult(removeDuplicatesSimplified(nums8), nums8);

        final int[] nums6 = {1, 1, 2, 3};
        printResult(removeDuplicates(nums6), nums6);

        final int[] nums7 = {1, 2, 2, 3};
        printResult(removeDuplicates(nums7), nums7);

        final int[] nums9 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        printResult(removeDuplicates(nums9), nums9);
    }

    public static void printResult(int res, int[] resultArray) {
        System.out.println("Res = " + res);
        System.out.println(IntStream.of(resultArray).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int temp = -101;
        int idx = 0;
        int res = 0;
        int offset = 0;
        while (idx < nums.length) {
            if (idx == 0) {
                temp = nums[0];
                res++;
                idx++;
                continue;
            }

            if (temp == nums[idx] || nums[idx] == -101) {
                if (nums[idx] != -101) {
                    offset++;
                }
                if (nums.length > (idx + offset)) {
                    int x = nums[idx + offset];
                    nums[idx + offset] = -101;
                    nums[idx] = x;
                    continue;
                } else {
                    nums[idx] = -101;
                    break;
                }
            } else {
                temp = nums[idx];
                res++;
            }

            idx++;
        }

        return res;
    }

    public static int removeDuplicatesSimplified(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}
