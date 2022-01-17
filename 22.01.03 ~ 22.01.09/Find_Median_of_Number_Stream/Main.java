package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
        insertNum(3);
        insertNum(1);
        findMedian();
        insertNum(5);
        findMedian();
        insertNum(4);
        findMedian();
    }

    private static void insertNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    private static void findMedian() {
        if (list.size() % 2 == 1) {
            System.out.println(list.get(list.size() / 2));
        } else {
            System.out.println((list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0);
        }
    }
}

/*
Design a class to calculate the median of a number stream. The class should have the following two methods:

insertNum(int num): stores the number in the class
findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

Example 1:

1. insertNum(3)
2. insertNum(1)
3. findMedian() -> output: 2
4. insertNum(5)
5. findMedian() -> output: 3
6. insertNum(4)
7. findMedian() -> output: 3.5

i
o calculate the median of a number stream
c include two methods
e

solution
1.
insertNum으로 숫자를 저장한다.
arraylist를 정렬한다.
list의 size가 홀수면 중앙에 위치한 값을 출력하고 짝수면 가운데 두 숫자의 평균값을 출력한다.

time O(N*logN)
space O(N)
 */