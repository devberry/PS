package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        Integer[] b = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (a[i] < b[i] && k > 0) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
                k--;
            }
        }

        int res = 0;
        for (int ac : a) {
            res += ac;
        }

        System.out.println(res);
    }
}

/*
i 첫 번째 줄 n,k, 두 번째 줄 a의 원소들, 세 번째 줄 b의 원소들
o 최대 k번 바꿔치기를 수행해서 만들 수 있는 배열 a의 모든 원소의 합
c 1<=n<=100000, 0<=k<=n, a와 b의 원소는 10000000보다 작다.
e

sol
1.
a를 오름차순으로 정렬, b를 내림차순으로 정렬한다.
for문을 돌면서 a와 b의 원소를 비교해서 a가 b보다 작으면 원소를 swap한다.
for문을 다 돌면 a의 합을 구해서 반환한다.

time O(nlogn)
space O(1)
 */