package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //버퍼 비우기
        sc.nextLine();
        String[] move = sc.nextLine().split(" ");

        int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
        int[] cur = {1,1};
        char[] moveType = {'L', 'R', 'U', 'D'};

        for (int i = 0; i < move.length; i++) {
            char m = move[i].charAt(0);
            int x = cur[0];
            int y = cur[1];

            for (int j = 0; j < moveType.length; j++) {
                if (m == moveType[j]) {
                    x += dir[j][0];
                    y += dir[j][1];
                }
            }

            if (x < 1 || y < 1 || x > n || y > n) {
                continue;
            }

            cur[0] = x;
            cur[1] = y;
        }

        System.out.println(cur[0] + " " + cur[1]);
    }
}

/*
i 공간의 크기 N, A가 이동할 방향들
o A가 도착하는 지점의 좌표
c 1,1에서 시작, 1<=N<=100, 1<=이동 횟수<=100, 공간 밖으로 벗어나는 움직임은 무시
e

sol
1.
L 0,-1
R 0,1
U -1,0
D 1,0
문자에 따라 위처럼 이동하도록 한다.

time O(m) m = 이동 횟수
space O(m)
 */