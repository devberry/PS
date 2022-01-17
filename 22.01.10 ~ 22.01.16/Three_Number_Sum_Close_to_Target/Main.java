package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {-2, 0, 1, 2};
        int target = 2;

        System.out.println(threeSumClosest(input, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;

        loop:
        for(int i = 0; i < nums.length - 2; i++) {
            int newTarget = target - nums[i];
            int low = i + 1;
            int high = nums.length - 1;

            while(low < high) {
                int curr = nums[low] + nums[high];

                if(curr < newTarget) {
                    if(Math.abs(newTarget - curr) < close) {
                        close = Math.abs(newTarget - curr);
                        res = curr + nums[i];
                    }
                    low++;
                } else if(curr > newTarget) {
                    if(Math.abs(newTarget - curr) < close) {
                        close = Math.abs(newTarget - curr);
                        res = curr + nums[i];
                    }
                    high--;
                } else {
                    res = curr + nums[i];
                    low++;
                    high--;
                    break loop;
                }

            }
        }

        return res;
    }
}

/*
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Example 1:

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:

Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.

i int: array, int: target
o find sum of three integer close to target
c 3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
e

sol
1. input array 정렬(오름차순)
포인터 하나를 잡아두고(target에서 뺀다) 나머지 두 포인터를 움직여서 target에 가까운 sum을 찾는다.
두 숫자의 sum에서 target을 뺀 절댓값이 기존의 close보다 작다면 갱신, 만약 0이면 탐색을 바로 종료

time O(n^2)
space O(1)
 */