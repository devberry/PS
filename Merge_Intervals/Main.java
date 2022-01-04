package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
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
input[i][0] < input[j][0] && input[i][1] > input[j][0] ex) [1,4], [2,5]
min = input[i][0]
    input[i][1] < input[j][1]
    max = input[j][1]
    else
    max = input[i][1]

input[i][0] > input[j][0] && input[j][1] > input[i][0] ex) [3,6], [2,4]
min = input[j][0]
    input[i][1] < input[j][1]
    max = input[j][1]
    else
    max = input[i][1]

이렇게 정하고 합쳐야 할 때마다 바로바로 합치고 새로 비교?
min max값 정하고 list를 전부 살펴본 뒤 한번에 합치기?
 */