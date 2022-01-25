package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * 2;
        }

        System.out.println(dp[n - 1] % 796796);
    }
}

/*
i n
o 2*n 크기 바닥을 채우는 방법의 수를 796,796으로 나눈 나머지(결괏값이 엄청 클 수도 있기 때문에 나누라고 하는 것)
c 1<=n=1000
e

sol
optimal
1.
n=3일 경우
왼쪽부터 타일을 채워나간다고 했을 때
i-1까지 타일로 채워져 있다고 하면 2x1 타일을 채우는 하나의 경우만 존재
i-2까지 타일로 채워져 있다고 하면 1x2 타일 2개로 채우거나 2x2 타일 하나로 채우는 두 가지 경우가 존재
2x1 타일 2개로 채우지 않는 이유는 i-1의 경우에서 이미 고려했기 때문이다.

따라서 점화식은 ai = ai-1 + ai-2 * 2이다.

time O(n)
space O(n)
 */