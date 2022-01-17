package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main (String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(nums);

        int res = 0;
        int cnt = M;

        while(cnt != 0) {
            for (int i = 0; i < K; i++) {
                if (cnt != 0) {
                    res += nums[N - 1];
                    cnt--;
                }
            }

            if (cnt != 0) {
                res += nums[N - 2];
                cnt--;
            }
        }

        bw.write(res);
    }
}

/*
i 배열 크기 N, 숫자가 더해지는 횟수 M, K
o 배열에서 주어진 수를 m번 더해서 가장 큰 수를 만든다.
c 배열의 특정 인덱스에 해당하는 수가 연속으로 k번을 초과하여 더해질 수 없다.
서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다.
2<=N<=1000, 1<=M<=10000, 1<=K<=10000,
K<=M
e

sol
1.
내림차순 정렬
가장 큰 수가 K번 더해지도록 한다.
M을 count로 설정하고 count가 0이 되지 않았을 경우 다음 인덱스의 숫자가 1번 더해지도록 한다.
위 과정을 반복한다.

time O(NlogN + M)
space O(N)
 */