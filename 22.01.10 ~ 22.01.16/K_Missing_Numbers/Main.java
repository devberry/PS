package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {-2, -3, 4};
        int k = 2;

        System.out.println(kMissingNumber(input, k).toString());
    }

    private static List<Integer> kMissingNumber(int[] input, int k) {
        List<Integer> res = new ArrayList<>();

        if(k == 0) {
            return res;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }

        int i = 1;
        int cnt = k;

        while (cnt > 0) {
            if (!set.contains(i)) {
                res.add(i);
                cnt--;
            }
            i++;
        }

        return res;
    }
}

/*
Given an unsorted array containing numbers and a number ‘k’,
find the first ‘k’ missing positive numbers in the array.

Example 1:

Input: [3, -1, 4, 5, 5], k=3
Output: [1, 2, 6]
Explanation: The smallest missing positive numbers are 1, 2 and 6.
Example 2:

Input: [2, 3, 4], k=3
Output: [1, 5, 6]
Explanation: The smallest missing positive numbers are 1, 5 and 6.
Example 3:

Input: [-2, -3, 4], k=2
Output: [1, 2]
Explanation: The smallest missing positive numbers are 1 and 2.

i int[]: unsorted array, int: number ‘k’
o first 'k' missing positive numbers
c
e k == 0 -> empty array return

sol
1.
set에 input을 돌면서 input[i]를 key로 저장
k를 count로 해서 k가 0이 될 때까지 반복
-> i를 1로 정해서 i가 set에 있는지 확인한 후 없으면 ouput에 i를 추가, 이후 i를 1씩 증가시키면서 해당 과정 반복 수행

time O(n + k) n == input.length
space O(n)
 */