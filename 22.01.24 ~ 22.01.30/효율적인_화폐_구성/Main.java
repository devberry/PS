package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] value = new int[n + 1];
        int[] money = new int[m + 1];

        for (int i = 1; i < n + 1; i++) {
            value[i] = sc.nextInt();
        }
        for (int i = 1; i < m + 1; i++) {
            money[i] = 10001;
        }

        for (int i = 1; i < n + 1; i++) {
            for(int j = value[i]; j < m + 1; j++) {
                money[j] = Math.min(money[j], money[j - value[i]] + 1);
            }
        }

        if (money[m] != 10001) {
            System.out.println(money[m]);
        } else {
            System.out.println(-1);
        }
    }
}

/*
i 화폐의 종류 n, 화폐를 최소한으로 사용해서 만들 금액 m, 각 화폐의 가치
o m원을 만들기 위한 화폐의 최소 개수, 불가능하면 -1 출력
c 1<=n<=100, 1<=m<=10000
e

sol
optimal
1.
k: 화폐 단위
i원을 만들기 위한 방법이 존재할 때
ai = min(ai, ai-k + 1)
방법이 존재하지 않을 때
ai = 10001

time O(nm)
space O(n + m)
 */
