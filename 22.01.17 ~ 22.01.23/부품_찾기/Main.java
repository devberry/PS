package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);

        for(int i = 0; i < m; i++) {
            if (binarySearch(arrN, arrM[i]) == -1) {
                bw.write("no ");
            } else {
                bw.write("yes ");
            }
            bw.flush();
        }
        bw.close();
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}

/*
i 정수 n, n개 정수(1<x<=1000000), 정수 m, m개 정수(1<y<=1000000)
o 각 부품이 존재하면 yes, 아니면 no 출력
c 1<=n<=1000000, 1<=m<=100000
e

sol
1.
단순히 순차 탐색으로 찾게 되면 O(nm), 즉 10^11의 시간복잡도가 되므로 이진 탐색을 사용한다.
데이터량이 많으므로 br, bw를 사용하는 게 좋을 수도 있다.

time O((m+n)logn)
space O(m+n)

2. 계수 정렬을 이용한 풀이

time O(m+n)
space O(m+2n = m+n)

3. set을 이용한 풀이

time O(m+n)
space O(m+2n = m+n)
 */