package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] input = {{1, 4}, {2, 6}, {3, 5}};

        System.out.println(Arrays.deepToString(mergeIntervals(input)));
    }

    private static int[][] mergeIntervals(int[][] input) {
        if (input.length == 1) {
            return input;
        }

        Arrays.sort(input, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] newIn = input[0];
        res.add(newIn);

        for (int[] in : input) {
            if (in[0] <= newIn[1]) {
                newIn[1] = Math.max(newIn[1], in[1]);
            } else {
                newIn = in;
                res.add(newIn);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}

/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Example 1:

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].

Example 2:

Intervals: [[6,7], [2,4], [5,9]]
Output: [[2,4], [5,9]]
Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].

Example 3:

Intervals: [[1,4], [2,6], [3,5]]
Output: [[1,6]]
Explanation: Since all the given intervals overlap, we merged them into one.

i int: a list of intervals
o merge all overlapping intervals
c
e input[].length == 1

solution
1.
interval의 0번째 원소를 기준으로 intervals를 오름차순 정렬한다.
list<int[]>를 만든다.
intervals[i][0]이 intervals[0]에 포함될 때마다 list의 end를 갱신한다.
포함되지 않게 되었을 때 다음 intervals를 기준으로 list를 위의 과정대로 갱신한다.

time O(N*logN)
space O(N)
 */