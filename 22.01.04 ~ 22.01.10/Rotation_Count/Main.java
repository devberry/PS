package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {4, 5, 7, 9, 10, -1, 2};

        System.out.println(rotationCount(input));
    }

    private static int rotationCount(int[] input) {
        if(input.length == 1) {
            return 0;
        }

        int min = input[0];
        int numCount = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i] < min) {
                min = input[i];
                numCount = i;
            }
        }

        return numCount;
    }
}

/*
Rotation Count (medium)#
Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.

You can assume that the array does not have any duplicates.

Example 1:

Input: [10, 15, 1, 3, 8]
Output: 2
Explanation: The array has been rotated 2 times.
    1
    3
    8
    10
    15
 Original array:
 Array after 2 rotations:
    10
    15
    1
    3
    8
Example 2:

Input: [4, 5, 7, 9, 10, -1, 2]
Output: 5
Explanation: The array has been rotated 5 times.
 Original array:
    -1
    2
    4
    5
    7
    9
    10
    4
    5
    7
    9
    10
    -1
    2
 Array after 5 rotations:
Example 3:

Input: [1, 3, 8, 10]
Output: 0
Explanation: The array has been not been rotated.

i 오름차순 array
o input array가 rotate한 횟수(없으면 0)
c
e array length == 1

solution
1. input array 정렬
정렬된 array의 최솟값이 input에서 몇번째 index에 위치하는지 조사한다.

time O(NlgN)
space O(1)

2. input array 0번째 index값을 min으로 지정
input array를 돌면서 min값을 갱신한다.
min이 마지막으로 갱신된 index를 알아낸다.

time O(N)
space O(1)
 */