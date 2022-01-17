package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int max = 0;

        for (int i = 0; i < N; i++) {
            int min = 10001;
            for (int j = 0; j < M; j++) {
                int x = sc.nextInt();
                min = Math.min(x, min);
            }
            max = Math.max(min, max);
        }

        System.out.print(max);
    }
}

/*
i 행의 개수:N, 열의 개수:M, N개의 줄에 걸쳐 각 카드에 적힌 숫자가 주어진다.
o 게임의 룰에 맞게 선택한 카드의 숫자
c 1<=N,M<=100
e

sol
1.
각 행마다 가장 작은 숫자를 찾아서 min에 저장한 뒤 행이 바뀔 때마다 max를 갱신한다.
max를 반환한다.

time O(N*M)
space O(1)
 */