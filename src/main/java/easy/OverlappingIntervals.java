package easy;

import java.util.*;

class OverlappingIntervals {

    public static void main(String[] args) {
        int[][] ints = mergeOverlappingIntervals(new int[][]{new int[]{1, 2}, new int[]{2, 3}});
        if (ints.length > 0) {
            System.out.println("wololo");
        }
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        List<IntervalPair> uniqueIntervals = new ArrayList<>();
        for (int[] ints : intervals) {
            int intervalStart = ints[0];
            int intervalEnd = ints[1];

            boolean newPair = true;
            for (IntervalPair pair : uniqueIntervals) {
                newPair = !pair.mergeInterval(intervalStart, intervalEnd);
            }

            if (newPair) {
                uniqueIntervals.add(new IntervalPair(intervalStart, intervalEnd));
            }

        }

        return uniqueIntervals.toArray(new int[uniqueIntervals.size()][]);
    }

    public static class IntervalPair {
        private int _start;
        private int _end;

        public IntervalPair(int start, int end) {
            _start = start;
            _end = _end;
        }

        private boolean contains(int num) {
            return _start >= num || _end <= num;
        }

        public int getStart() {
            return _start;
        }

        public int getEnd() {
            return _end;
        }

        public boolean mergeInterval(int start, int end) {
            if (contains(start) || contains(end)) {
                _start = Math.min(_start, start);
                _end = Math.max(_end, end);
                return true;
            }
            return false;
        }
    }
}