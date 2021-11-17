package medium;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MatchSticks {
    public static void main(String[] args) {
        boolean res = new MatchSticks().makesquare(new int[]{1,1,1,1,2,2,2,2,3,3,3,3});
        System.out.println(res);
    }


    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;

    public MatchSticks() {
        this.sums = new int[4];
    }

    // Depth First Search function.
    public boolean dfs(int index) {
        //First we need to check if all sides are equal when we exhausted all our numbers
        if (index == this.nums.size()) {
            //The trick here is that since the perimeter is already divisible by 4 we just need to check if we get 3 sides equal
            return this.sums[0] == this.sums[1] && this.sums[1] == this.sums[2] && this.sums[2] == this.sums[3];
        }

        int element = this.nums.get(index);

        //We iterate over the 4 sides and do recursion on them
        for (int i = 0; i < 4; i++) {
            //If current element fits in this side spot we add it and recurse again
            if (this.sums[i] + element <= this.possibleSquareSide) {
                this.sums[i] += element;
                //We keep trying to accommodate the next number
                if (this.dfs(index + 1)) {
                    return true;
                }
                //Basically the idea is that if we get here is because the sum didn't work for the side deep down in the DFS
                this.sums[i] -= element;
            }

        }

        //This is basically if we ended but we couldn't complete a solution trying out all combinations
        return false;

    }

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }

        int perimeter = IntStream.of(nums).sum();
        possibleSquareSide = perimeter / 4;
        //Check if it was a no remainder division
        if (possibleSquareSide * 4 != perimeter) {
            return false;
        }

        this.nums = IntStream.of(nums).boxed().collect(Collectors.toList());
        //Trick here is to reverse the array just so we have the biggest number @ index 0, if this is a greater number than the possibleSquareSide we can fail fast
        this.nums.sort(Collections.reverseOrder());
        return this.dfs(0);
    }
}
