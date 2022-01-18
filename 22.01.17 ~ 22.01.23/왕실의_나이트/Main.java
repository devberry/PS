package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        String cur = sc.nextLine();
        int[][] dir = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};

        int row = cur.charAt(1) - '0';
        int col = cur.charAt(0) - 'a' + 1;
        int cnt = 0;

        for(int i = 0; i < dir.length; i++) {
            int nRow = row + dir[i][0];
            int nCol = col + dir[i][1];

            if (nRow < 1 || nCol < 1 || nRow > 8 || nCol > 8) {
                continue;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}

/*
i 나이트 현재 위치 ex) a1
o 현재 위치에서 주어진 룰에 따라 이동할 수 있는 경우의 수
c 8x8 좌표 평면, 정원 밖으로는 나갈 수 없음
e

sol
1.
(1,2),(1,-2),(-1,2),(-1,-2)
(2,1),(2,-1),(-2,1),(-2,-1)

time O(1)
space O(1)

int row = cur.charAt(1) - '0';
int col = cur.charAt(0) - 'a' + 1;
char to int 변환 방법이므로 잘 알아두자.
 */