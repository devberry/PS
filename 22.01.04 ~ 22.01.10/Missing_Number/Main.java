package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {8, 3, 5, 2, 4, 6, 0, 1};

        System.out.println(missingNumber(input));
    }

    private static int missingNumber(int[] input) {
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }

        int realSum = input.length * (input.length + 1) / 2;

        return realSum - sum;
    }
}

/*
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Example 1:

Input: [4, 0, 3, 1]
Output: 2
Example 2:

Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7

i int: an array(containing n distinct num)
o array에서 0부터 n까지의 숫자 중 빠진 숫자
c 0 <= array[i] <= n
e

solution
1.
n+1개의 공간을 가진 배열 생성(check)
input array 돌면서 check[input[i]] = true
다 돌았으면 check를 돌면서 false인 index 찾기

time O(N) N == input.length
space O(N)

2.
n(n+1)/2 -> 1부터 n까지의 합
input array 돌면서 합을 구함
n(n+1)/2 - array's sum -> 빠진 숫자

time O(N)
space O(1)
 */