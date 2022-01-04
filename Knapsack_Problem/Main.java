package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int cap = 200;
        int[][] items = {
                {465, 100},
                {400, 85},
                {255, 55},
                {350, 45},
                {650, 130},
                {1000, 190},
                {455, 100},
                {100, 25},
                {1200, 190},
                {320, 65},
                {750, 100},
                {50, 45},
                {550, 65},
                {100, 50},
                {600, 70},
                {255, 40}
        };
        int[][] test = {
                {1, 3},
                {2, 4},
                {3, 5},
                {4, 1},
                {5, 7}
        };
        int[][] dpTable = new int[items.length + 1][cap + 1];

        calcMaxValue(items, cap, dpTable);
        traceIndex(items, dpTable);
    }

    private static void calcMaxValue(int[][] items, int cap, int[][] dpTable) {
        int maxValue = 0;

        for(int i = 1; i < items.length + 1; i++) {
            for(int j = 1; j < cap + 1; j++) {
                int curValue = items[i - 1][0];
                int curCap = items[i - 1][1];

                if(curCap > j) {
                    dpTable[i][j] = dpTable[i - 1][j];
                    continue;
                }
                dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i - 1][j - curCap] + curValue);
                maxValue = Math.max(maxValue, dpTable[i][j]);
            }
        }

        for(int i = 0; i < dpTable.length; i++) {
            for(int j = 0; j < dpTable[0].length; j++) {
                System.out.print(dpTable[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print(maxValue + ", ");
    }

    private static void traceIndex(int[][] items, int[][] dpTable) {
        Deque<Integer> index = new LinkedList<>();
        int row = dpTable.length - 1;
        int col = dpTable[0].length - 1;

        while(col > 0) {
            if (dpTable[row][col] != dpTable[row - 1][col]) {
                index.add(row - 1);
                col -= items[row - 1][1];
            }
            row--;
        }

        Iterator<Integer> iter = index.descendingIterator();
        while (iter.hasNext()) {
            int it = iter.next();
            System.out.print(it + " ");
        }
    }
}

/*
{
  "capacity": 200,
  "items": [
    [465, 100],
    [400, 85],
    [255, 55],
    [350, 45],
    [650, 130],
    [1000, 190],
    [455, 100],
    [100, 25],
    [1200, 190],
    [320, 65],
    [750, 100],
    [50, 45],
    [550, 65],
    [100, 50],
    [600, 70],
    [255, 40]
  ]
}
[1505, [7, 12, 14, 15]]

solution
       0 1 2 3 4 5 6 7 8 9 10
    [] 0 0 0 0 0 0 0 0 0 0 0
[1, 3] 0 0 0 1 1 1 1 1 1 1 1
[2, 4] 0 0 0 1 2 2 2 3 3 3 3
[3, 5] 0 0 0 1 2 3 3 3 4 5 5
[4, 1] 0 4 4 4 5 6 7 7 7 8 9
[5, 7] 0 4 4 4 5 6 7 7 9 9 9

1. Math.max(dpTable[i - 1][cap], dpTable[i - 1][cap - curCap] + curValue)
2. 해당 index의 값과 이전 index의 값을 비교해서 다르면 위로 올라감. 같으면 해당 index를 deque에 추가.

 */
