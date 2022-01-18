package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    sb.append(i);
                    sb.append(j);
                    sb.append(k);

                    for (int s = 0; s < sb.length(); s++) {
                        if (sb.charAt(s) == '3') {
                            cnt++;
                            sb.setLength(0);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}

/*
i 정수 N
o 3이 하나라도 포함되는 모든 경우의 수
c 0<=N<=23
e

sol
1.
3중 for문을 이용해 완전탐색을 진행한다.
시각을 1초씩 늘려가면서 그때마다 string으로 바꿔서 3이 포함되어 있는지 확인한다.

time O(86400 = 1)
space O(1)

StringBuilder를 사용할 때 setLenth(0)으로 초기화 해주는 걸 잊지 말자.
 */