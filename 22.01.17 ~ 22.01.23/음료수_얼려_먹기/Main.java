package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ice = new int[n][m];
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ice[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(ice, i, j)) {
                    res += 1;
                }
            }
        }

        System.out.println(res);
    }

    public static boolean dfs(int[][] ice, int row, int col) {
        if(row >= ice.length || col >= ice[0].length || row < 0 || col < 0) {
            return false;
        }

        if (ice[row][col] == 0) {
            ice[row][col] = 1;

            int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

            for(int[] d : dir) {
                dfs(ice, row + d[0], col + d[1]);
            }

            return true;
        }

        return false;
    }
}

/*
i 세로 길이 N, 가로 길이 M, 두 번째 줄부터 N+1번째 줄까지 틀의 형태
o 만들 수 있는 아이스크림 갯수
c 1<=N,M<=1000
e

sol
1.
dfs로 탐색한다.
현재 구멍에서 상하좌우 탐색
값이 0이면서 방문하지 않은 구멍이 인접해있다면 해당 구멍을 탐색
틀의 범위를 벗어날 경우 종료

time O(nm)
space O(nm)
 */