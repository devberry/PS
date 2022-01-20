package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sc.nextLine();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}

/*
i 수열에 속해 있는 수 개수 n, 둘째 줄부터 n+1번째 줄까지 N개의 수
o 입력된 수열이 내림차순으로 정렬된 결과
c 1<=n<=500, 1<=수<=100000
e n=1

sol
1.
정렬 라이브러리를 사용해서 내림차순으로 정렬한다.

time O(nlogn)
space O(n)
 */