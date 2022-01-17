package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;

//        while (N != 1) {
//            if (N % K == 0) {
//                N /= K;
//                cnt++;
//            } else {
//                N -= 1;
//                cnt++;
//            }
//        }

        while(true) {
            //N이 K로 나누어 떨어지는 수가 될 때까지 1씩 빼기
            int target = (N / K) * K;
            cnt += N - target;
            N = target;

            //N을 K로 더 이상 나눌 수 없을 때 반복문 탈출
            if(N < K) {
                break;
            }

            //K로 나누기
            N /= K;
            cnt += 1;
        }

        //남은 수가 1이 될 때까지 1씩 빼기
        cnt += N - 1;
        System.out.println(cnt);
    }
}


/*
i 자연수 N, K
o N을 1로 만들기 위해 필요한 최소 횟수
c 2<=N<=100000, 2<=K<=100000, N>=K
e

sol
1.
N이 K로 나누어 떨어지는지 확인한다.
나누어 떨어지면 K로 나눈다. cnt++
그렇지 않으면 1을 뺀다. cnt++
1이 될 때까지 위 과정을 반복한다.
cnt를 반환한다.

time O(N)
space O(1)
 */