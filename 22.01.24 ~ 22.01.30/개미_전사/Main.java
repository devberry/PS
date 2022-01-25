package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] food = new int[n];
        for (int i = 0; i < n; i++) {
            food[i] = sc.nextInt();
        }

        int[] dp = new int[100];
        dp[0] = food[0];
        dp[1] = food[1];

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + food[i]);
        }

        System.out.println(dp[n - 1]);
    }
}

/*
i 식량창고의 개수 n, 각 식량창고에 저장된 식량의 개수 k
o 얻을 수 있는 식량의 최댓값
c 3<=n<=100, 0<=k<=1000, 약탈하는 창고끼리 한 칸 이상은 떨어져 있어야 함
e

sol
optimal
1.
현재 식량창고 i번
i-1번을 털면 i번을 털 수 없다.
i-2번을 털면 i번을 털 수 있다.
위 두 선택지 중에서 선택
ai = max(ai-1,ai-2 + k)

time O(n)
space O(n)
 */