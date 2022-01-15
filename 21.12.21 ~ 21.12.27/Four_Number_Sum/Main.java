package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {7, 6, 4, -1, 1, 2};
        int targetSum = 16;

        fourNumberSum(arr, targetSum);
    }

    private static void fourNumberSum(int[] arr, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if(arr.length < 4) {
            System.out.println(res.toString());
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 3; i++) {
            for(int j = i + 1; j < arr.length - 2; j++) {
                int low = j + 1;
                int high = arr.length - 1;
                int sum = targetSum - arr[i] - arr[j];

                while(low < high) {
                    if(arr[low] + arr[high] == sum) {
                        res.add(Arrays.asList(arr[i], arr[j], arr[low++], arr[high--]));
                    }
                    else if(arr[low] + arr[high] < sum) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }

        System.out.println(res.toString());
    }
}

/*
i int[]: array(distinct integers), int: targetSum
o int[][]: array
c no array -> return empty array
e input array.length < 4 -> return empty array

solution
1.
input array를 정렬한다.(포인터를 움직일 기준을 만들기 위해서)
target에서 index i, i + 1의 원소를 뺀다.
이후의 포인터 low, high를 이용해서 합이 target과 일치할 경우의 원소를 list에 넣는다.

time O(n^3)
space ?
 */