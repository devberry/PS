package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int height = binarySearch(arr, m);
        if (height != -1) {
            System.out.println(height);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = (int) 1e9;

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > mid)
                    sum += arr[i] - mid;
            }

            if (sum == target) {
                return mid;
            } else if (sum > target) { // 떡의 양이 충분할 경우 덜 자른다.
                start = mid + 1;
            } else { // 떡의 양이 부족할 경우 더 자른다.
                end = mid - 1;
            }
        }

        return -1;
    }
}

/*
i 떡의 개수 n, 요청한 떡의 길이 m, 떡의 개별 높이,
o 적어도 m만큼의 떡을 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값
c 1<=n<=1*10^6, 1<=m<=2*10^9, 0<=높이<=1*10^9, 떡 길이의 총합은 항상 m 이상
e

sol
1.
10 14 17 19, 6
10 14 15 15
0 0 2 4

brute force
떡의 개별 높이를 정렬해서 가장 길이가 짧은 떡의 길이를 절단기 높이로 설정한다.
떡을 잘라서 잘린 떡의 총 길이를 구한다.
총 길이가 m과 같으면 현재 절단기 높이를 반환한다.

time O(nlogn + n^2) -> 데이터의 범위가 10억, 20억이므로 무조건 TLE가 뜰 것으로 예상된다.

optimal
이처럼 데이터의 범위가 넓을 때는 바로 이진 탐색을 떠올릴 수 있어야 한다.

시작점을 0, 끝점을 가장 긴 떡의 길이로 설정
중간점을 절단기 길이로 설정
현재 절단기 길이로 얻는 떡 길이의 총합이 m보다 크면 끝점을 절단기 길이 - 1로 설정
그렇지 않으면 시작점을 절단기 길이 + 1로 설정
일치하면 현재 절단기 길이를 반환

time O(2nlogn = nlogn)
space O(n)
 */