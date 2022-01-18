package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        sc.nextLine();

        int[] cur = new int[2];
        cur[0] = sc.nextInt();
        cur[1] = sc.nextInt();
        int to = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        //캐릭터가 처음 위치한 곳은 이미 방문한 것이므로 1로 시작
        int cnt = 1;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        //4가 되면 네 방향 모두 이동 불가하다는 의미
        int impossible = 0;

        while(true) {
            int x = cur[0];
            int y = cur[1];
            //현재 타일 방문 여부 표시
            map[x][y] = -1;

            //방향 회전
            to++;
            if(to > 3) {
                to = 0;
            }

            //이동 여부 판별
            int nextX = x + dir[to][0];
            int nextY = y + dir[to][1];
            //이동할 곳이 육지인 경우 이동
            if(map[nextX][nextY] == 0) {
                cur[0] = nextX;
                cur[1] = nextY;
                impossible = 0;
                cnt++;
            }

            impossible++;
            //네 방향 모두 갈 수 없을 경우
            if (impossible == 4) {
                nextX = cur[0] + dir[to][0] * -1;
                nextY = cur[0] + dir[to][1] * -1;
                //뒤쪽이 바다가 아닐 경우엔 뒤로 한 칸 이동한다.
                if (map[nextX][nextY] != 1) {
                    cur[0] = nextX;
                    cur[1] = nextY;
                } else {
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}

/*
i
o
c
e

sol
1.
 */