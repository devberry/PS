package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] dp = new int[30000];
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        for (int i = 2; i < x + 1; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }

        System.out.println(dp[x]);
    }
}

/*
i 정수 x
o 주어진 연산 4개를 이용해서 1로 만들기 위해 연산하는 횟수의 최솟값
c 1<=x<=30000
e x==1

sol
brute force
1.
x가 1이면 return x
연산을 최소로 하기 위해선 수를 많이 줄일 수 있는 순(abcd)으로 연산을 하도록 한다.
재귀함수와 전역변수 max를 사용해서 함수를 한번 호출할 때마다 max를 1씩 증가시키도록 한다.

time O(2^n)

optimal
1.
다이나믹 프로그래밍을 사용한다.
ai = min(ai-1,ai/5,ai/3,ai/2) + 1

time O(n)
space O(n)
 */