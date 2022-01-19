package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void bfs(int[][] maze, int row, int col) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

            for(int[] d : dir) {
                int tempX = cur[0] + d[0];
                int tempY = cur[1] + d[1];

                if(tempX < 0 || tempY < 0 || tempX >= maze.length || tempY >= maze[0].length) {
                    continue;
                }

                if(maze[tempX][tempY] == 0) {
                    continue;
                }

                if(maze[tempX][tempY] == 1) {
                    maze[tempX][tempY] = maze[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{tempX,tempY});
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] maze = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        bfs(maze,0,0);

        System.out.println(maze[n-1][m-1]);
    }
}

/*
i 정수 n,m, 다음 n개의 줄에 각각 m개의 정수(미로)
o 최소 이동 칸 개수
c 동빈이 위치 (1,1), 출구 위치 (n,m), 시작 칸과 마지막 칸은 항상 1, 4<=n,m<=200
e

sol
1.
최소 이동 칸의 개수를 구하므로 bfs를 사용한다.
int[] 안에 x,y 좌표가 들어가는 형태로 큐에 저장한다.
다음 타일로 이동할 때 이전 타일까지의 이동거리를 더해준다.
마지막에 maze[n-1][m-1]을 반환한다.

time O(nm)
space O(nm)
 */
